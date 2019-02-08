package javabeans;

public class UserInformation {
	private String SSN;
	private String role;
	private String profileName;
	
	public UserInformation(String SSN, String role,
			String profileName) {
		this.SSN = SSN;
		this.role = role;
		this.profileName = profileName;
	}
	
	public String getSSN() {
		return SSN;
	}
	public String getRole() {
		return role;
	}
	
	public String getProfileName() {
		return profileName;
	}
}
