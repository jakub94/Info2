package Chatterbox_II;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;


public class Server implements Runnable
{
	private ArrayList<Session> sessions;
	private ArrayList<String> commandKeywords;
	private ConnectionListener connectionListener;

	public static void main(String[] args)
	{
		ServerSocket serverSocket;

		try
		{
			serverSocket = new ServerSocket(55555);
			Server server = new Server(serverSocket);
			Thread t = new Thread(server);
			t.start();
		} 

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public Server(ServerSocket serverSocket)
	{
		this.sessions = new ArrayList<Session>();
		this.commandKeywords = new ArrayList<String>();
		connectionListener = new ConnectionListener(serverSocket);

		commandKeywords.add("nick");
		commandKeywords.add("quit");
	}

	private boolean hasKeyword(String message)
	{
		for(String keyword : commandKeywords)
		{
			if(message.indexOf("/" + keyword) == 0)
				return true;
		}
		return false;
	}

	private void distributeMessage(Session sender, String message) 
	{
		for(Session session: sessions)
		{
			if(!session.equals(sender))
			{
				if(!session.isClosed())
				{
					System.out.println("send \"" + message + "\" to " + session.getSocket().getRemoteSocketAddress());
					session.send(message);
				}
			}
		}
	}


	private void executeCommand(String[] args, Session session)
	{
		switch(args[0])
		{
			case "/quit":
			{
				session.close();
				break;
			}
			case "/nick":
			{
				if(args.length > 1)
				{
					String oldNick = session.getNick();
					session.setNick(args[1]);
					distributeMessage(session, "*** " + oldNick + " changed his nick to " + args[1] + " ***");
				}
				
				break;
			}
		}
	}

	private void handleIncomingMessages() throws IOException
	{
		Iterator<Session> iterator = sessions.iterator();
		while(iterator.hasNext())
		{
			Session session = iterator.next();
			if(session.hasNewInput())
			{
				String msg = session.getMessage();

				if(hasKeyword(msg))
				{
					String[] args = msg.split(" ");						
					executeCommand(args, session);
				
				}
				else
					distributeMessage(session, session.getNick() + ": " + msg);
			}
		}
	}
	private void disposeClosedSessions()
	{
		Iterator<Session> iterator = sessions.iterator();
		while(iterator.hasNext())
		{
			Session session = iterator.next();
			if(session.isClosed())
			{
				distributeMessage(session, "*** " + session.getNick() + " disconnected... ***");
				iterator.remove();
			}
		}
	}
	public void run()
	{
		System.out.println("Server is running...");
		connectionListener.start();

		while(true)
		{
			if(connectionListener.hasNewSocket())
			{
				try
				{
					Session session = new Session(connectionListener.getClientSocket());
					session.start(); 
					sessions.add(session);

					System.out.println(session.getSocket().getRemoteSocketAddress() + " connected...");
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			try
			{
				handleIncomingMessages();
				disposeClosedSessions();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
