package Chatterbox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread
{ 
    private ServerSocket serverSocket; 
 
    
    public ChatServer(int port) throws IOException
    {
        System.out.println("Listening to port: " + port);
        this.serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(30000); //30 seconds
        
        
    }
    
    public static void main(String[] args)
    {
        int port = 0;
        try
        {
            port = Integer.parseInt(args[0]);
            try
            {
                ChatServer chatServer = new ChatServer(port);
                chatServer.start();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage() + "\nStacktrace: " + ex.getStackTrace());
            }       
        }
        catch(Exception ex)
        {
            System.out.println("Invalid port\n" + ex.getMessage());
        }       
    }
    
  @Override
    public void run()
    {    
        while(true)
        {
            try
            {
                Socket socket = serverSocket.accept(); //Waits for connection
                System.out.println("Connection established to " + socket.getInetAddress() + " on port:" + socket.getLocalPort() + "\n");
                
                ChatClient client = new ChatClient(socket);
                client.start();         
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage() + "\nServer shut down...");
                break;
            }
        }
      }       
}

