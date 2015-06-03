package ProbabilisticAlgorithms.DiningPhilosophers;
public class PhilosophersDemo {

	public static void main(String[] args) 
	{

		String n = args[0];

		if(n.equals("0"))
		{
			startSimulation(); 
		}
		else if(n.equals("1"))
		{
			produceDeadlock();
		}
		else
			System.out.println("Invalid Argument");

	}

	public static void startSimulation()
	{
		Philosopher a = new Philosopher("A");
		Fork f1 = new Fork();
		Philosopher b = new Philosopher("B");
		Fork f2 = new Fork();
		Philosopher c = new Philosopher("C");
		Fork f3 = new Fork();
		Philosopher d = new Philosopher("D");
		Fork f4 = new Fork();
		Philosopher e = new Philosopher("E");
		Fork f5 = new Fork();


		a.setLeftFork(f5);
		a.setRightFork(f1);
		b.setLeftFork(f1);
		b.setRightFork(f2);
		c.setLeftFork(f2);
		c.setRightFork(f3);
		d.setLeftFork(f3);
		d.setRightFork(f4);
		e.setLeftFork(f4);
		e.setRightFork(f5);

		a.start();
		b.start();
		c.start();	
		d.start();
		e.start();
	}
	
	public static void produceDeadlock()
	{
		DeadLockPhilosopher a = new DeadLockPhilosopher("A");
		Fork f1 = new Fork();
		DeadLockPhilosopher b = new DeadLockPhilosopher("B");
		Fork f2 = new Fork();
		DeadLockPhilosopher c = new DeadLockPhilosopher("C");
		Fork f3 = new Fork();
		DeadLockPhilosopher d = new DeadLockPhilosopher("D");
		Fork f4 = new Fork();
		DeadLockPhilosopher e = new DeadLockPhilosopher("E");
		Fork f5 = new Fork();

		
		a.setLeftFork(f5);
		a.setRightFork(f1);
		b.setLeftFork(f1);
		b.setRightFork(f2);
		c.setLeftFork(f2);
		c.setRightFork(f3);
		d.setLeftFork(f3);
		d.setRightFork(f4);
		e.setLeftFork(f4);
		e.setRightFork(f5);
		
		a.start();
		b.start();
		c.start();	
		d.start();
		e.start();
		
		f1.take(a);
		f2.take(b);
		f3.take(c);
		f4.take(d);
		f5.take(e);
	}
	
}