package Chatterbox_II;
import java.util.Scanner;


public class ConsoleInterface implements ChatClientInterface
{
	public ConsoleInterface()
	{
		
	}
	
	public void printMessage(String message)
	{
		System.out.println(message);
	}
	
	public String readMessage()
	{
		return (new Scanner(System.in).nextLine());
	}
}
