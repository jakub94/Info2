package Chatterbox;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;


public class ChatClient extends Thread
{
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ChatOutMsgListener inputListener;
    private ChatIncMsgListener incMsgListener;
    
    
    public static void main(String[] args)
    {
         String ip = args[0];
         int port = Integer.parseInt(args[1]);

           
        try
        {
            ChatClient client = new ChatClient(ip, port);
            client.start();  
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
           
         
     }
    
         public ChatClient(Socket socket)
         {
             this.socket = socket;
             
             try 
             {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
             } 
             catch (IOException e) 
             {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
             
             inputListener = new ChatOutMsgListener();
             inputListener.start();
             
             incMsgListener = new ChatIncMsgListener(in);
             incMsgListener.start();

         }
         
         public ChatClient(String ip, int port) throws IllegalArgumentException
         {
             if(ConnectToChatServer(ip, port))
             {
                 inputListener = new ChatOutMsgListener();
                 inputListener.start();
                 
                 incMsgListener = new ChatIncMsgListener(in);
                 incMsgListener.start();
             }
             else
                 throw new IllegalArgumentException("Unable to connect...");
             
         }
           
         public void run()
         {
             while(socket.isConnected() && !socket.isClosed() && incMsgListener.isAlive())
             {
                 if(inputListener.quit())
                 {
                     try 
                     {
                        socket.close();
                     } 
                     catch (IOException e) 
                     {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                     }
                     break;
                 }
                 
                 else if(inputListener.hasNewInput())
                 {
                     try 
                     {
                        out.writeUTF(inputListener.getInput());
                     } 
                     catch (IOException e) 
                     {
                        e.printStackTrace();
                     }       
                 }
                                
                if(incMsgListener.hasNewMessage())
                    System.out.println(socket.getRemoteSocketAddress() + ": " + incMsgListener.getMessage());
             }
               
             System.out.println("Disconnected from " + socket.getRemoteSocketAddress());
             }
         
            
         public boolean ConnectToChatServer(String ip, int port)
         {
             try
             {
                System.out.println("Trying to connect to: " + ip + " on port: " + port);
                socket = new Socket(ip, port);
                if(socket.isConnected() && !socket.isClosed())
                {
                    System.out.println("Successfully connected...\n");
                    out = new DataOutputStream(socket.getOutputStream());   
                    in = new DataInputStream(socket.getInputStream());
                    return true;
                }
                return false;
             }
             catch (UnknownHostException ex)
             {
                 System.out.println("Unknown host: " + ip);
                 return false;
             }
             catch (IOException ex)
             {
                 System.out.println("Error: " + ex.getMessage());
                 return false;
             }
         }
         
    
}

