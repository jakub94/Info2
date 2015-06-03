package CinemaBookingSystem;
import java.util.ArrayList;

public class CinemaBookingSystem 
{
	private ArrayList<Reservation> reservations;
	public CinemaBookingSystem()
	{
		reservations = new ArrayList<>();
	}
	
	public void makeReservation(Customer customer, Show show, int row, int seatNumber, int numberOfSeats)
	{
		if(checkInput(show, row, seatNumber, numberOfSeats))
		{
			ArrayList<Seat> bookedSeats;
			bookedSeats = show.bookSeats(row, seatNumber, numberOfSeats);
			if(bookedSeats == null)
				System.out.println("In row: " + row + " were no " + numberOfSeats + " free, continuous seats, including seat " + seatNumber + ", found!");
			else
			{
				Reservation reservation = new Reservation(customer, show);
				reservations.add(reservation);
				reservation.setBookedSeats(bookedSeats);
			}
		}
	}
	
	public void cancelReservation(Reservation reservation)
	{
		reservation.getShow().freeSeats(reservation.getBookedSeats()); 	
		reservations.remove(reservation);
	}
	
	public void printReservations()
	{
		String s = "Reservations:\n\n";
		for(Reservation res: reservations)
		{
			s += "Customer: " + res.getCustomer().getName() +
					" booked " + res.getBookedSeats().size() +
					" seats for the movie " + res.getShow().getMovie().getName() +
					" at " + (res.getShow().getDate().getHour() + ":" + res.getShow().getDate().getMinute()) +
					" for a total price of " + res.getPrice() + "\n\n";
		}
		System.out.println(s);
		
	}
	
	public ArrayList<Reservation> getReservations()
	{
		return this.reservations;
	}
	
	private boolean checkRowNumber(Show show, int row)
	{
		return (row < 0 || show.getTheater().getSeats().length < row);
	}
	
	private boolean checkNumberOfSeats(int numberOfSeats)
	{
			return (numberOfSeats < 1);
	}

	private boolean checkSeatNumber(Show show, int row, int seatNumber)
	{
			int c = show.getTheater().getSeats()[row].length;
			return (c < seatNumber || seatNumber < 0);
	}
	
	private boolean checkInput(Show show, int row, int seatNumber, int numberOfSeats)
	{
			String error = "";
			
			if(checkNumberOfSeats(numberOfSeats))
				error += "Invalid number of seats!\n";
			
			if(checkRowNumber(show, row))
				error += "Invalid row number!\n";
			else
				if(checkSeatNumber(show, row, seatNumber))
					error += "Invalid seat number!\n";						
			
			System.out.println(error);
			return(error == "");
	}

	
	
	
}
	
