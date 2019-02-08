package javabeans;

import java.util.Date;

public class SuggestedBy {
	private String custRep;
	private String profileB;
	private String profileC;
	private Date Date_Time;
	
	public SuggestedBy() {
		
	}
	
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	
	public String getProfileB() {
		return profileB;
	}
	public void setProfileB(String profileB) {
		this.profileB = profileB;
	}
	
	public String getProfileC() {
		return profileC;
	}
	public void setProfileC(String C) {
		this.profileC = C;
	}

	public Date getDateTime() {
		return Date_Time;
	}
	public void setDateTime(Date date) {
		this.Date_Time = date;
	}
}
