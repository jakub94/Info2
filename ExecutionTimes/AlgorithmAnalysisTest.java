package ExecutionTimes;

public class AlgorithmAnalysisTest {

	public static void main(String[] args) 
	{	
		//Interesting value overflow
		System.out.println(PrimeNumbers.isPrime(19));  //Test if number is prime 
		System.out.println(PrimeNumbers.binaryRepresentation(2)); 
		System.out.println();
		
		
		for(int n = 5 ; n < 501 ; n=n*10)
		{
			System.out.println("1 - " + n +  ": " + CodeFragments.frag1(n));
			System.out.println("2 - " + n +  ": " + CodeFragments.frag2(n));
			System.out.println("3 - " + n +  ": " + CodeFragments.frag3(n));
			System.out.println("4 - " + n +  ": " + CodeFragments.frag4(n));
			System.out.println("5 - " + n +  ": " + CodeFragments.frag5(n));
			System.out.println("6 - " + n +  ": "  + CodeFragments.frag6(n));
			System.out.println("7 - " + n +  ": "  + CodeFragments.frag7(n));
		}
		

		long start = System.currentTimeMillis();
		for(long i = 1048576; i < 1048676;i++)
			PrimeNumbers.isPrime(i);
		long end = System.currentTimeMillis();
		
		System.out.println("20bit " + (end - start) + "ms");
		
		long tmp = new Long("1099511627876");
		start = System.currentTimeMillis();
		for(long i = new Long("1099511627776"); i < tmp;i++)
			PrimeNumbers.isPrime(i);
		end = System.currentTimeMillis();
		
		System.out.println("40bit " + (end - start) + "ms");
	}

}
