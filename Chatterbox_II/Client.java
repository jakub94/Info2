package Chatterbox_II;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends Thread
{
	private boolean connected;
	private ChatClientInterface chatClientInterface; 
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;


	public Client(ChatClientInterface chatClientInterface) 
	{
		super();
		this.connected = false;
		this.chatClientInterface = chatClientInterface;
		
	} 

	public boolean isConnected() 
	{
		return connected;
	}
	public Socket getSocket() 
	{
		return socket;
	}
	
	public void connect(String ipAddress, int port) throws IOException , UnknownHostException
	{
		this.socket = new Socket(InetAddress.getByName(ipAddress), port);
		
		try
		{
			setupStreams(socket);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		this.connected = true;
	}
	
	public void setupStreams(Socket socket) throws IOException
	{
		this.in = new DataInputStream(socket.getInputStream());
		this.out = new DataOutputStream(socket.getOutputStream()); 
	}
	
	public void sendMessage(String message)
	{
		try
		{
			out.writeUTF(message);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}	
	}
	
	public void run() 
	{
		ConsoleInputListener listener = new ConsoleInputListener();
		listener.start();
		
		OutputListener oListener = new OutputListener(in);
		oListener.start();
		while(Thread.currentThread().isAlive())
		{
			if(listener.hasNewInput())
				sendMessage(listener.getInput());
			if(oListener.hasNewMessage())
				receiveMessage(oListener.getMessage());
		}
	}
	
	public void receiveMessage(String msg)
	{
		chatClientInterface.printMessage(msg); 
	}
	
}
