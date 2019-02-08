package javabeans;

import java.util.Calendar;
import java.util.Date;


public class salesReport {

	private String custRepSSN;
	private String profileA;
	private String profileB;
	private int fees;
	private Calendar date;
	
	
	public String getCustRepSSN() {
		return custRepSSN;
	}
	
	public void setCustRepSSN(String custRepSSN) {
		this.custRepSSN = custRepSSN;
	}
	
	public String getProfileA() {
		return profileA;
	}
	
	public void setProfileA(String profileA) {
		this.profileA = profileA;
	}

	public String getProfileB() {
		return profileB;
	}

	public void setProfileB(String profileB) {
		this.profileB = profileB;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
}
