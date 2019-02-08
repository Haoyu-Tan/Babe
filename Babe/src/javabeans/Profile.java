package javabeans;

import java.sql.Date;
import java.util.Calendar;

public class Profile {
	
	private String profileID;
	private String ownerSSN;
	private int age;
	private int datingAgeRangeStart;
	private int datingAgeRangeEnd;
	private int datingGeoRange;
	private String gender;
	private String hobbies;
	private double height;
	private double weight;
	private String hairColor;
	private Calendar creationDate;
	private Calendar lastModDate;

	public Profile() {
		
	}
	
	public String getProfileID() {
		return profileID;
	}
	
	public void setProfileID(String r) {
		profileID = r;
	}
	
	public String getOwnerSSN() {
		return ownerSSN;
	}
	
	public void setOwnerSSN(String r) {
		ownerSSN = r;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getDatingAgeRangeStart() {
		return datingAgeRangeStart;
	}
	
	public void setDatingAgeRangeStart(int datingAgeRangeStart) {
		this.datingAgeRangeStart = datingAgeRangeStart;
	}
	
	public int getDatingAgeRangeEnd() {
		return datingAgeRangeEnd;
	}

	public void setDatingAgeRangeEnd(int datingAgeRangeEnd) {
		this.datingAgeRangeEnd = datingAgeRangeEnd;
	}
	

	public int getDatingGeoRange() {
		return datingGeoRange;
	}
	
	public void setDatingGeoRange(int datingGeoRange) {
		this.datingGeoRange = datingGeoRange;
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String r) {
		gender = r;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(String r) {
		hobbies = r;
	}
	
	public String getHairColor() {
		return hairColor;
	}
	
	public void setHairColor(String r) {
		hairColor = r;
	}
	
	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
	public Calendar getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Calendar lastModDate) {
		this.lastModDate = lastModDate;
	}

	
}
