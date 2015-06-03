package ExecutionTimes;
public class PrimeNumbers {
	
	public static boolean isPrime(long n)
	{
		for(int i = 2; i < n; i++)
		{
			if((n % i) == 0)
				return false;
		}
		return true; 
	}
	
	public static int binaryRepresentation(int n)
	{
		return 1 + (int)(Math.floor((Math.log(n) / Math.log(2))));  
	}	
}
