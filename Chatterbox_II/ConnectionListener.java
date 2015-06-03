package Chatterbox_II;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ConnectionListener extends Thread
{
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private boolean hasNewSocket;

	public ConnectionListener(ServerSocket serverSocket)
	{
		this.serverSocket = serverSocket;
		hasNewSocket = false;
		this.setDaemon(true);
	}

	public void run() 
	{
		while(Thread.currentThread().isAlive())
		{
			if(clientSocket == null)
			{
				try
				{
					this.clientSocket = serverSocket.accept();
					//System.out.println("Serversocket accepted connection...");

					synchronized (this)
					{
						hasNewSocket = true;	
					}
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
			}

		}
	}

	public Socket getClientSocket()
	{
		synchronized (this)
		{
			hasNewSocket = false;
			Socket s = clientSocket;
			clientSocket = null;
			return s;
		}
	}

	public boolean hasNewSocket()
	{
		synchronized (this)
		{
			return hasNewSocket;
		}
	}
}
