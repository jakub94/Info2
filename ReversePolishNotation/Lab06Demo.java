package ReversePolishNotation;

import java.util.Scanner;

public class Lab06Demo 
{
	public static void main(String[] args)
	{
		Postfix pf = new Postfix(); 
		String infix = ""; 
		Scanner scanner = null; 
		
		try
		{
			 
		    scanner = new Scanner(System.in); 
			infix = scanner.nextLine(); 
			System.out.println( pf.evaluate(pf.infixToPostfix(infix)) ); 
		}
		
		catch(IllegalArgumentException illegalArgumentException)
		{
			System.out.println("The input is not formated in correct postfix notation");
		}
	
		catch(UnderflowException e)
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
		
		try 
		{
			System.out.println(pf.infixToPostfix(infix));
		} 
		catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		} 
		catch (UnderflowException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	
		
}
