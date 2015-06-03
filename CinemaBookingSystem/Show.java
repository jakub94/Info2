package CinemaBookingSystem;
import java.util.ArrayList;
public class Show 
{
	private Date date;
	private Theater theater;
	private double price;
	private Movie movie;
	private Seat[][] seats;
	
	public Show(Date date, Theater theater, double price, Movie movie)
	{
		this.date = date;
		this.theater = theater;
		this.setPrice(price);
		this.movie = movie;
		this.seats = theater.getSeats();
	}
	public Show()
	{
	
	}

	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public Theater getTheater()
	{
		return theater;
	}
	
	public void setTheater(Theater theater)
	{
		this.theater = theater;
	}
	
	public Movie getMovie()
	{
		return movie;
	}
	
	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price) throws IllegalArgumentException
	{
		double roundPrice = Math.round(price*100)/100.0;
		if (roundPrice < 0.00)
			throw new IllegalArgumentException("Invalid argument! Price must be greater than zero");
		this.price = roundPrice;
	}
	
	public ArrayList<Seat> bookSeats(int row, int seatNumber, int numberOfSeats)
	{
		int start = seatNumber - numberOfSeats +1;
		int end = seatNumber + numberOfSeats -1;
				
		
		if(start < 0)
			start = 0;
		
		if(end > seats[row].length - 1)
			end = seats[row].length - 1;
		
		ArrayList<Seat> bookedSeats = new ArrayList<>();
		for(int i = start; i <= end; i++)
		{
			if(!seats[row][i].isOccupied())
				bookedSeats.add(seats[row][i]);
			else
				bookedSeats = new ArrayList<>();
			
			if(bookedSeats.size() >= numberOfSeats)
			{
				for(Seat seat : bookedSeats)
					seat.occupySeat();
				
				takeSeats(bookedSeats);
				return bookedSeats;
			}
		}
		return null;
	}
	
	private void takeSeats(ArrayList<Seat> bookedSeats)
	{
		for(Seat bookedSeat : bookedSeats)
		{
			for(int i = 0; i < seats.length; i++)
			{
				for(int j = 0; j < seats[i].length; j++)
				{
					if(bookedSeat.getRowNumber() == seats[i][j].getRowNumber() && bookedSeat.getColNumber() == seats[i][j].getColNumber())
						seats[i][j].occupySeat();
				}
			}
		}
	}
	
	public void freeSeats(ArrayList<Seat> bookedSeats)
	{
		for(Seat seat : bookedSeats)
		{
			int row = seat.getRowNumber();
			int col = seat.getColNumber();
			seats[row][col].freeSeat();
		}
	}
	
	public String GetSeatingPlan()
	{
		String s ="Seating Plan of " + theater.getName();
		for(int i = 0; i < seats.length; i++)
		{
			for(int j = 0; j < seats[i].length; j++)
			{
				s += "\nRow " + i + " seat " + j + " is ";
				if(seats[i][j].isOccupied())
					s += " taken";
				else
					s += " free";
			}
		}
		
		return s;
	}
}
