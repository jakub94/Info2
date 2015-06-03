package CinemaBookingSystem;
public class Theater 
{
	
	private Seat[][] seats;
	private String name;
	
	public Theater()
	{
		
	}
	
	public Theater(String name, int rows, int cols)
	{
		createSeats(rows, cols);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Seat[][] getSeats() 
	{
		return seats;
	}
	
	public void createSeats(int rows, int cols) throws IllegalArgumentException
	{
		if ((rows < 1) || (cols < 1))
			throw new IllegalArgumentException();
		
		this.seats = new Seat[rows][cols];
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
				this.seats[i][j] = new Seat(i,j);
		}

	}


}
