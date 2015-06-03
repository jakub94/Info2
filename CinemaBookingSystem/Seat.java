package CinemaBookingSystem;
public class Seat 
{
	public Seat()
	{
		
	}
	
	public Seat(int rowNumber, int colNumber)
	{
		this.colNumber = colNumber;
		this.rowNumber = rowNumber;
	}
	
	private int colNumber;
	private int rowNumber;
	private boolean occupied;
	
	public int getColNumber()
	{
		return colNumber;
	}
	
	public void setColNumber(int colNumber) throws IllegalArgumentException
	{
		if(colNumber < 1)
			throw new IllegalArgumentException("Invalid argument! colNumber cannot be smaller than zero");
		
		this.colNumber = colNumber;
	}
	
	public int getRowNumber() 
	{
		return rowNumber;
	}
	
	public void setRowNumber(int rowNumber) 
	{
		if(rowNumber < 1)
			throw new IllegalArgumentException("Invalid argument! row number cannot be smaller than zero");
		
		this.rowNumber = rowNumber;
	}
	
	public boolean isOccupied() 
	{
		return occupied;
	}
	
	public void freeSeat() 
	{
		this.occupied = false;
	}
	public void occupySeat()
	{
		this.occupied = true;
	}
}
