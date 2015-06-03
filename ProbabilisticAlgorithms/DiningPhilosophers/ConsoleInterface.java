package ProbabilisticAlgorithms.DiningPhilosophers;

public class ConsoleInterface implements DiningPhilosophers{

	@Override
	public synchronized void output(String out) 
	{
		System.out.println(out);		
	}

}
