package Chatterbox_II;

public class ChatClient
{

	
	public static void main(String[] args)
	{
		if(args.length != 2)
			System.out.println("Invalid number of arguments!");
		
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		
		Client client = new Client(new ConsoleInterface());

		try
		{
			System.out.println("Trying to connect to " + ip + ":" + port);
			client.connect(ip, port);
			System.out.println("Connection established...");
			client.start();
		}
		

		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		while(client.isConnected()){ }
	}

}
