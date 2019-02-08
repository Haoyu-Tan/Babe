package javabeans;

import java.util.Date;

public class Referral {
	private String profileA;
	private String profileB;
	private String profileC;
	private Date Date_Time;
	
	public Referral() {}
	
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
	
	public String getProfileC() {
		return profileC;
	}
	
	public void setProfileC(String profileC) {
		this.profileC = profileC;
	}
	
	public Date getDateTime() {
		return Date_Time;
	}
	
	public void setDateTime(Date Date_Time) {
		this.Date_Time = Date_Time;
	}

}
