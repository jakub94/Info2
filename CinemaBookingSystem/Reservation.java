package CinemaBookingSystem;
import java.util.ArrayList;

public class Reservation 
{
	private Customer customer;
	private double price;
	private Show show;
	private ArrayList<Seat> bookedSeats; 
	
	public Reservation()
	{
		
	}
	
	public Reservation(Customer customer, Show show)
	{
		this.customer = customer;
		this.show = show;	
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws IllegalArgumentException
	{
		double roundPrice = Math.round(price*100)/100.0;
		if (roundPrice < 0.00)
			throw new IllegalArgumentException("Price must be greater than zero");
		this.price = roundPrice;
	}

	public Show getShow() 
	{
		return show;
	}

	public void setShow(Show show) 
	{
		this.show = show;
	}

	public void setBookedSeats(ArrayList<Seat> seats)
	{
		this.bookedSeats = seats;
		this.price = calculatePrice(seats.size());
	}
	
	public ArrayList<Seat> getBookedSeats() {
		return bookedSeats;
	}
	
	private double calculatePrice(int numberOfTickets)
	{
		return show.getPrice() * numberOfTickets;
	}



	

}
