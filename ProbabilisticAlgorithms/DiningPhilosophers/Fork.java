package ProbabilisticAlgorithms.DiningPhilosophers;
public class Fork {
	
	private Philosopher reserverdBy; 
	private Philosopher takenBy;
	private DiningPhilosophers diningPhilosophers = new ConsoleInterface();
	

	public synchronized void  take(Philosopher p)
	{
		if(takenBy != null)
		{
			if( p != takenBy)
			{
				this.reserve(p); 
			}
		}
		else
		{
			this.takenBy = p; 
		}
	}
	
	public synchronized void reserve(Philosopher p)
	{
		diningPhilosophers.output(p.getName() + " " + "has to wait for a fork");
		this.reserverdBy = p; 
		try
		{
			this.wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		this.takenBy = null;
		this.take(p); 
	}
	
	public synchronized void drop(Philosopher p)
	{
		this.takenBy = null; 
		
		if(this.reserverdBy != null)
		{
			this.notifyAll();
		}
	}
	
}
