package javabeans;

import java.sql.Date;
import java.util.Calendar;

public class Dates {
	
	private String profile1;
	private String profile2;
	private String custRep;
	private Calendar date_time;
	private String location;
	private double bookingFee;
	private String comments;
	private int user1Rating;
	private int user2Rating;
	
	
	public Dates() {
		
	}
	
	public String getProfile1() {
		return profile1;
	}
	
	public void setProfile1(String p) {
		profile1 = p;
	}
	
	public String getProfile2() {
		return profile2;
	}
	
	public void setProfile2(String p) {
		profile2 = p;
	}
	
	public String getCustRep() {
		return custRep;
	}
	
	public void setCustRep(String p) {
		custRep = p;
	}
	
	public Calendar getDateTime() {
		return date_time;
	}

	public void setDateTime(Calendar date_time) {
		this.date_time = date_time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String p) {
		location = p;
	}
	
	public double getBookingFee() {
		return bookingFee;
	}
	
	public void setBookingFee(double p) {
		bookingFee = p;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String p) {
		comments = p;
	}
	
	public int getUser1Rating() {
		return user1Rating;
	}

	public void setUser1Rating(int rating) {
		user1Rating = rating;
	}
	
	public int getUser2Rating() {
		return user2Rating;
	}

	public void setUser2Rating(int rating) {
		user2Rating = rating;
	}
}
