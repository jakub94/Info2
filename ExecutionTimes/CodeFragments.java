package ExecutionTimes;
public class CodeFragments 
{
	
	// Fragment #1
	public static long frag1(int n) 
	{
		long sum = 0; 
	for(int i = 0; i < n; i ++)
	{
	     sum++;
	     
	}
		return sum; 
	}
	
	
	// // Fragment #2
	public static long frag2(int n) 
	{
    long sum = 0; 
	 for ( int i = 0; i < n; i ++)
	     for ( int j = 0; j < n; j ++)
	         sum++;
		return sum; 
	}



	 



	 // Fragment #3
	public static long frag3(int n) 
	{
    long sum = 0; 
	 for ( int i = 0; i < n; i ++)
	     for ( int j = i; j < n; j ++)
	         sum++;
		return sum; 
	}




	 // Fragment #4	
	public static long frag4(int n) 
	{
    long sum = 0; 
    for ( int i = 0; i < n; i ++)
	     sum ++;
	     for ( int j = 0; j < n; j ++)
	         sum ++;
		return sum; 
	}
	




	 // Fragment #5
	public static long frag5(int n) 
	{
    long sum = 0; 
	 for ( int i = 0; i < n; i ++)
	     for ( int j = 0; j < n*n; j ++)
	     sum++;
		return sum; 
	}

	
	 // Fragment #6
	public static long frag6(int n) 
	{
    long sum = 0; 
	 for ( int i = 0; i < n; i ++)
	     for ( int j = 0; j < i; j ++)
	         sum++;
		return sum; 
	}


	

	// Fragment #7
	public static long frag7(int n) 
	{
		long sum = 0; 
		long s0 = 0;
		long s1 = 0;
		long s2 = 0;
		
		for ( int i = 1; i < n; i ++)
		{
			s0++;
			for( int j = 0; j < n*n; j ++)
			{
				s1++;
				if (j % i == 0)
				{
					s2++;
					for (int k = 0; k < j; k++)
					{
						sum++;
					}
				}

			}
		}
		/*
		System.out.println(s0);
		System.out.println(s1);
		System.out.println(s2);
		*/
		return sum; 
	}
}
