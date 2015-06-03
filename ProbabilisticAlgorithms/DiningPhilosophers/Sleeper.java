package ProbabilisticAlgorithms.DiningPhilosophers;
import java.util.Random;


public class Sleeper {
	
	private static Random random = new Random(System.currentTimeMillis());
	
	public static synchronized void sleepRandom()
	{
		long millis = (long) (random.nextDouble() * 5000);
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void sleepRandom(int n)
	{
		long millis = (long) (random.nextDouble() * n);
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void sleep(int millis)
	{
		try
		{
			Thread.sleep(millis);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
