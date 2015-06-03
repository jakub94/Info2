package Chatterbox_II;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Session extends Thread
{

	private Socket socket; 
	private DataOutputStream out;
	private DataInputStream in; 
	
	private String nick; 
	private String message; 
	private boolean closed;
	private boolean hasNewInput;

	public void close()
	{
		this.closed = true;
	}
	
	public boolean isClosed()
	{
		return closed;
	}
	
	public String getNick()
	{
		return nick;
	}

	public void setNick(String nick)
	{
		this.nick = nick;
	}



	
	public Socket getSocket()
	{
		return socket;
	}


	


	public Session(Socket socket) throws IOException
	{
		super();
		this.socket = socket;
		this.closed = false;
		this.nick = socket.getRemoteSocketAddress().toString();
		setupStreams();
	}

	private void setupStreams() throws IOException
	{
		out = new DataOutputStream(socket.getOutputStream());
		out.flush();
		in = new DataInputStream(socket.getInputStream()); 

	}


	public void send(String message)
	{
		try
		{
			out.writeUTF(message);
		}
		catch(IOException ex)
		{
			this.close();
		}
	}


	private void receive() throws IOException
	{
		message = in.readUTF(); 
		hasNewInput = true; 
	}

	public String getMessage()
	{
		hasNewInput = false;

		String msg = this.message;
		this.message = null; 

		return msg;
	}

	public boolean hasNewInput()
	{
		return hasNewInput;
	}


	@Override
	public void run() 
	{
		while(Thread.currentThread().isAlive())
		{
			if(!hasNewInput)
			{
				try
				{
					receive();
				} 
				catch (IOException e)
				{
					this.closed = true;
					return;
				}
			}
		}


	}
}
