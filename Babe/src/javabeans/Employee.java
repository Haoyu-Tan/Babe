package javabeans;

import java.sql.Date;
import java.util.Calendar;

public class Employee extends Person{


	
	private String role;
	private Calendar startDate;
	private int hourlyRate;
	
	public Employee() {
		
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String r) {
		role = r;
	}

	
	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startD) {
		startDate = startD;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

}
