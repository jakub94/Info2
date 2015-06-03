package CinemaBookingSystem;


public class Customer 
{
	private String name;
	private String phoneNr;
	
	
	public Customer()
	{
	
	}
	
	public Customer(String name, String phoneNr) 
	{
		this.name=name;
		this.phoneNr=phoneNr;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setPhoneNr(String phoneNr)
	{
		this.phoneNr=phoneNr;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getPhoneNr()
	{
		return this.phoneNr;
	}

}
