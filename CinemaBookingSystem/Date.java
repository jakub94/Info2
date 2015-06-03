package CinemaBookingSystem;

public class Date 
{
	private int year, month, day, hour, minute;
	public Date()
	{
		
	}
	public Date(int year, int month, int day, int hour, int minute)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;	
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	public String toString() 
	{
		String date = new String(""); 
		
		switch (month) 
		{
        case 1:  date = "January";
                 break;
        case 2:  date = "February";
                 break;
        case 3:  date = "March";
                 break;
        case 4:  date = "April";
                 break;
        case 5:  date = "May";
                 break;
        case 6:  date = "June";
                 break;
        case 7:  date = "July";
                 break;
        case 8:  date = "August";
                 break;
        case 9:  date = "September";
                 break;
        case 10: date = "October";
                 break;
        case 11: date = "November";
                 break;
        case 12: date = "December";
                 break;
        default: date = "Invalid month";
                 break;
		}
		
		date = date + " " + day + ". " + year + " " +  hour + "." + minute;
		
		return date; 
                 
		
	}
	
	
	
	

}
