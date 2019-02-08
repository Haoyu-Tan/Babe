package javabeans;

public class Login {
	private String SSN;
	private String profileID;
	private String password;
	
	public Login() {}
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfile(String profileID) {
		this.profileID = profileID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
