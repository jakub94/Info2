package ReversePolishNotation;
public class Postfix 
{
	//Stores integers used for evaluation 
	AwesomeIncredibleSuperMasterStack<Integer> stack = new 	AwesomeIncredibleSuperMasterStack<Integer>();
	//stores chars used for conversion from infix to postfix 
	AwesomeIncredibleSuperMasterStack<Character> pfxStack = new 	AwesomeIncredibleSuperMasterStack<Character>();

	public int evaluate(String pfx) throws IllegalArgumentException 
	{
		try
		{
			int i = 0; 
			do

			{
				char currentChar = pfx.charAt(i);
				char nextChar;  



				if (isOperand(currentChar))
				{
					if( i < (pfx.length() -1))
					{
						nextChar = pfx.charAt(i+1);	
					}
					else
					{
						nextChar = ' '; 
					}

					if(isOperand(nextChar))
					{
						stack.push( (Character.getNumericValue(currentChar) * 10) + Character.getNumericValue(nextChar));
						i++; 
					}
					else
					{
						stack.push(Character.getNumericValue(currentChar));
					}
				}
				else if (isOperator(currentChar))
				{
					popCalcPush(currentChar);
				}

				i++; 	
			} while (i < pfx.length());
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException(); 
		}

		try
		{
			return stack.pop(); 
		}
		catch(UnderflowException exception)
		{
			exception.printStackTrace(); 
		}
		System.out.println("Critical Error");
		return -1; 
	}

	private boolean isOperand(char c)
	{
		return Character.isDigit(c); 
	}

	private boolean isOperator(char c)
	{		
		switch(c){
		case '+':
			return true; 
		case '-':
			return true; 
		case '*':
			return true; 
		case '/':
			return true; 
		case '^':
			return true; 
		default:
			return false;
		}
	}	

	private boolean isParenthese(char c)
	{
		return c=='('; 
	}


	private void popCalcPush(char operator)
	{
		int b = 0;
		int a = 0;
		try
		{
			b = stack.pop();
			a = stack.pop(); 
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		int result = calculate(a, b, operator); 

		stack.push(result); 

	}



	private int calculate(int a, int b, char operator ){

		switch(operator){
		case '+':
			return a + b;

		case '-':
			return a - b;

		case '*':
			return a * b;

		case '/':
			return a / b;

		case '^':
			return (int)Math.pow((double)a, (double)b);

		default:
			return 0;
		}
	}

	public String infixToPostfix (String ifx) throws IllegalArgumentException, UnderflowException
	{
		AwesomeIncredibleSuperMasterStack<Character> output = new AwesomeIncredibleSuperMasterStack<Character>();
		char currentChar; 
		String postfix = ""; 
		for(int i = 0; i < ifx.length(); i++)
		{
			currentChar = ifx.charAt(i); 
			if(isOperand(currentChar))
			{
				postfix += currentChar + " "; 
			}
			if(isOperator(currentChar))
			{	
				while(!output.isEmpty())
				{
					if(output.peek().equals(comparePrecedence(output.peek(), currentChar))) //If top of the stack has higher precedence
						postfix += output.pop() + " ";	
					else if (!output.isEmpty() && comparePrecedence(output.peek(), currentChar) == null)
					{
						postfix += output.pop() + " ";
						break;
					}
					else
						break;
				}

				output.push(currentChar);
			}
			if(isParenthese(currentChar))
			{
				int closingIndex = ifx.lastIndexOf(')'); 
				String betweenParentheses = ifx.substring(i+1, closingIndex); //Extract substring (.......) from original String
				i += betweenParentheses.length(); 
				postfix += infixToPostfix(betweenParentheses); 
			}


			while(!output.isEmpty()) // add all operators that remain in the stack
			{
				postfix += output.pop()+ " ";
			}
		}
		return postfix;

	}
	private int getPrecedence(char operator) throws IllegalArgumentException
	{
		switch(operator)
		{
		case  '+': { return 1;}
		case  '-': { return 1;}
		case  '*': { return 2;}
		case  '/': { return 2;}
		case  '^': { return 3;}
		default: 
		{
			throw new IllegalArgumentException("Illegal operator: " + operator);
		}
		}
	}
	private Character comparePrecedence(char a, char b)
	{
		int ap = getPrecedence(a);
		int bp = getPrecedence(b);

		if(ap > bp)
			return a;
		else if (bp > ap)		
			return b;
		else 
			return null;
	}


}
