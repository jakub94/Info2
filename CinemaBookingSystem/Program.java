package CinemaBookingSystem;
public class Program 
{

	public static void main(String[] args) 
	{
		test();
	}
	
	public static void test()
	{
		CinemaBookingSystem cbs = new CinemaBookingSystem();
		
		Movie movie = new Movie("The Lord Of The Rings - Return Of The King", 186, "The third and final part in the triology.");
		Theater theater = new Theater("Cinestar",3, 5);
		Show show = new Show(new Date(2014, 05, 01, 20, 30), theater, 7.50, movie);
		Customer michaela = new Customer("Michaela Wurstwasser", "0190671912");
		Customer mark = new Customer("Mark Hundetod", "016233211");
		Customer peter = new Customer("Peter Ingridson", "017073821");
		
		//All seats free
		System.out.println(show.GetSeatingPlan());
		
		//First booking
		cbs.makeReservation(michaela, show, 1, 2, 5);
		System.out.println(show.GetSeatingPlan());
		
		//Second booking
		cbs.makeReservation(peter, show, 0, 2, 2);
		System.out.println(show.GetSeatingPlan());
		
		//Attempt to book taken seats
		cbs.makeReservation(michaela, show, 0, 2, 2);
		System.out.println(show.GetSeatingPlan());
		
		//third booking
		cbs.makeReservation(mark, show, 2, 1, 1);
		System.out.println(show.GetSeatingPlan());
		
		cbs.printReservations();
		
		//Cancel first Reservation
		cbs.cancelReservation(cbs.getReservations().get(0));
	
		cbs.printReservations();
		System.out.println(show.GetSeatingPlan());
		
	}
}
