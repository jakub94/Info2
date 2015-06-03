package ProbabilisticAlgorithms.DiningPhilosophers;
public class Philosopher extends Thread {
	
	private Fork rightFork;
	private Fork leftFork; 
	private DiningPhilosophers diningPhilosophers;
	
	
	public Philosopher(String name)
	{
		super(name); 
		diningPhilosophers = new ConsoleInterface();
	}
	public Fork getRightFork() {
		return rightFork;
	}
	public void setRightFork(Fork rightFork) {
		this.rightFork = rightFork;
	}
	public Fork getLeftFork() {
		return leftFork;
	}
	public void setLeftFork(Fork leftFork) {
		this.leftFork = leftFork;
	}
	@Override
	public void run()
	{
		while(true)
		{
			
			//Philosopher not hungry, waiting for hunger
			diningPhilosophers.output(getName() + " " + "is waiting"); 
			Sleeper.sleepRandom();
			
			
			//Philosopher is hungry, trying to take the fork
			diningPhilosophers.output(getName() + " " + "is hungry");
			 
			rightFork.take(this);
			diningPhilosophers.output(getName() + " " + "takes his right fork");
			
			leftFork.take(this);
			diningPhilosophers.output(getName() + " " + "takes his left fork"); 
		
		
			
			//Philosopher is eating like a Boss
			diningPhilosophers.output(getName() + " " + "is eating..."); 
			Sleeper.sleepRandom();
			
			//Philosopher is done eating
			diningPhilosophers.output(getName() + " " + "is done eating"); 
			diningPhilosophers.output(getName() + " " + "is dropping his right fork"); 
			rightFork.drop(this);
			leftFork.drop(this);
			diningPhilosophers.output(getName() + " " + "is dropping his left fork"); 

			
		}
	}

}
