package utilServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Account;
import javabeans.Profile;
import javabeans.User;
import sql.EmployeeData;
import sql.SqlConnection;
import sql.UsersData;
import sql.WebpgUtil;

@WebServlet("/signup")
public class userSignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public userSignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		System.out.println("USER SIGNUP PAGE");

		String contextPath = request.getContextPath();

		User newUser = new User();
		Account newUserAccount = new Account();
		Profile newProfile = new Profile();
		
		String registered = request.getParameter("registered");
		System.out.println("registered value is " + registered);

		String SSN = request.getParameter("SSN");
		String password = request.getParameter("Password");
		String passwordConfirm = request.getParameter("PasswordConf");

		

		
		Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		
		String profileID = request.getParameter("profileID");
		String age = request.getParameter("age");
		String ageRangeStart = request.getParameter("ageRangeStart");
		String ageRangeEnd = request.getParameter("ageRangeEnd");
		String gender = request.getParameter("gender");
		String hobbies = request.getParameter("hobbies");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String hairColor = request.getParameter("hairColor");
		
		newProfile.setOwnerSSN(SSN);
		newProfile.setProfileID(profileID);
		newProfile.setAge(Integer.parseInt(age));
		newProfile.setDatingAgeRangeStart(Integer.parseInt(ageRangeStart));
		newProfile.setDatingAgeRangeEnd(Integer.parseInt(ageRangeEnd));
		newProfile.setGender(gender);
		newProfile.setHobbies(hobbies);
		newProfile.setWeight(Double.parseDouble(weight));
		newProfile.setHeight(Double.parseDouble(height));
		newProfile.setHairColor(hairColor);
		newProfile.setCreationDate(cal);
		newProfile.setLastModDate(cal);
		
		
		

		boolean submitted = request.getParameter("signupBtn") != null;
		System.out.println("in sign up");
		// Insert new user info to Database, This code will insert the sign up
		// information into Person and Customer table.
		try {
			System.out.println("Connection Fail");
			SqlConnection sc = new SqlConnection();
			sc.readDatabase();
			System.out.println("Connection Success");
			//System.out.println("Hello?");
			
			if (!SSN.matches("^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$")) {
				System.out.println("inSSN CHECK");
				inputValidate.validateSSN(true);
				response.sendRedirect(contextPath + "/signUp.jsp");
				sc.close();
				return;
			}
			
			if (password.equals(passwordConfirm) == false) {
				System.out.println("in password comfirm");
				inputValidate.setMismatch(true);
				response.sendRedirect(contextPath + "/signUp.jsp");
				sc.close();
				return;
			}

			//if (!cardNum.matches("^\\d{15,16}$")) {
			//	System.out.println("in number");
			//	inputValidate.validateCCD(true);
			///	response.sendRedirect(contextPath + "/signUp.jsp");
			///	sc.close();
			//	return;
			//}
			System.out.println("before case1");
			//case 1
			if (UsersData.searchProfile(sc.getConnected(), profileID) != null) {
				//Duplicate profileID
				System.out.println("duplicate profile");
				response.sendRedirect(contextPath + "/DuplicateProfileName.jsp");
				
			}
			else {
				System.out.println("before case 2");
			//case2
				if(registered != null) {
					System.out.println("registered is yes");
					 if (UsersData.searchPerson(sc.getConnected(), SSN) != null) {
				    	WebpgUtil.storeUserAccount(response, newUser);
				    	UsersData.insertProfile(sc.getConnected(), newProfile);	
				    	response.sendRedirect(contextPath + "/CreatedAcctSuccess.jsp");
				    	
				    }
					else {
						response.sendRedirect(contextPath + "/PersonDoesNotExist.jsp");
					}
					
				}
				else{
					System.out.println("registered is no");
					String firstName = request.getParameter("FirstName");
					String lastName = request.getParameter("LastName");
					String street = request.getParameter("Street");
					String city = request.getParameter("City");
					String state = request.getParameter("State");
					int zipcode;
					try {
						zipcode = Integer.parseInt(request.getParameter("Zipcode"));
					} catch (Exception e) {
						inputValidate.validateZip(true);
						response.sendRedirect(contextPath + "/signUp.jsp");
						return;
					}
					String email = request.getParameter("Email");
					String telephone = request.getParameter("Telephone");
					// String PPP = request.getParameter("PPP");
					// int rating = Integer.parseInt(request.getParameter("Rating"));
					
					//String cardNum = request.getParameter("CreditCardNo");
					// String acctNum = request.getParameter("AccountNumber");
					System.out.println("after getting information");
					newUser.setSSN(SSN);
					newUser.setPassword(password);
					newUser.setFirstName(firstName);
					//newUser.setFirstName(firstName);
					newUser.setLastName(lastName);
					newUser.setStreet(street);
					newUser.setCity(city);
					newUser.setState(state);
					newUser.setzip(zipcode);
					newUser.setemail(email);
					newUser.setTelephone(telephone);
					newUser.setPPP("User-user");
					// newUser.setRating(rating);
					newUser.setLastAct(cal);
	
					newUserAccount.setAcctCreationDate(cal);
					newUserAccount.setCardNum("0");
					//////////////// ----------------------------------/////////////////////////
					newUserAccount.setAccountNum("null");
					newUserAccount.setSSN(SSN);
					System.out.println("after create new user");
					if((UsersData.searchPerson(sc.getConnected(), SSN) == null) 
							&& (UsersData.searchUser(sc.getConnected(), SSN) == null)) {
						System.out.println("in case 3");
						WebpgUtil.storeUserAccount(response, newUser);
						UsersData.insertPerson(sc.getConnected(), newUser);
						UsersData.addCustomer(sc.getConnected(), newUser);
						UsersData.insertProfile(sc.getConnected(), newProfile);
						
					}
					else if (UsersData.searchPerson(sc.getConnected(), SSN) != null) {
						System.out.println("in case4");
						WebpgUtil.storeUserAccount(response, newUser);
						System.out.println("telephone is " + newUser.gettelephone());
						UsersData.updateCustomer(sc.getConnected(), newUser);
						UsersData.insertProfile(sc.getConnected(), newProfile);
						
						
					}
					response.sendRedirect(contextPath + "/CreatedAcctSuccess.jsp");
					
					
				} 

			// System.out.println("Problem?");
			sc.close();
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			response.sendRedirect(contextPath + "/Error.jsp");
		} catch (ClassNotFoundException ex) {
			System.out.println("Class Not Found" + ex.getMessage());
			response.sendRedirect(contextPath + "/Error.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.sendRedirect(contextPath + "/Error.jsp");
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
