package CinemaBookingSystem;

public class Movie {
	
	private String name;
	private String description;
	private int length;
	
	public Movie()
	{
		
	}
	
	public Movie(String name, int length, String description)
	{
		this.description=description;
		this.name=name;
		setLength(length); 
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) throws IllegalArgumentException
	{
		if (length < 1)
			throw new IllegalArgumentException("length must be greater than zero");
		this.length = length;
	}

	public String getName() {
		return name;
	}

}
