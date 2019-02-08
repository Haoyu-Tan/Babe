package javabeans;

public class Person {
	private String SSN;
	private String password;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private String email;
	private String telephone;
	
	public Person() {
			
	}
	
	public String getSSN() {
		return SSN;
	}
	
	public void setSSN(String newSSN) {
		this.SSN = newSSN;
	}
	
	public String getpassword() {
		return password;
		
	}
	
	public void setPassword(String newpwd) {
		this.password = newpwd;
		
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setFirstName(String newFN) {
		this.firstName = newFN;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String newLN) {
		this.lastName = newLN;
		
	}
	
	public String getStreet() {
		return street;
		
	}
	
	public void setStreet(String newStreet) {
		this.street = newStreet;
		
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String newState) {
		this.state = newState;
		
	}
	
	public int getzip() {
		return zipcode;
	} 

	public void setzip(int newzip) {
		this.zipcode = newzip;		
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String newEmail) {
		this.email = newEmail;
	}
	
	public String gettelephone() {
		return telephone;
	}
	
	public void setTelephone(String tele) {
		this.telephone = tele;
	}
	


}
