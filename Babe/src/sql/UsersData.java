package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javabeans.Account;
import javabeans.Employee;
import javabeans.Person;
import javabeans.Profile;
import javabeans.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UsersData {
	

	//Person
	public static void insertPerson(Connection connection, Person person) throws SQLException{
		String sql = "insert into hsinlin.Person(SSN,Password,FirstName,LastName,Street,City,State,Zipcode,Email,Telephone)" 
						+ "values(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
		 
		ps.setString(1, person.getSSN());
		ps.setString(2, person.getpassword());
		ps.setString(3, person.getfirstName());
		ps.setString(4, person.getLastName());
		ps.setString(5, person.getStreet());
		ps.setString(6, person.getCity());
		ps.setString(7, person.getState());
		ps.setInt(8, person.getzip());
		ps.setString(9, person.getemail());
		ps.setString(10, person.gettelephone());	
		ps.executeUpdate(); 
	}
	
	public static Person searchPerson(Connection connection, String SSN) throws SQLException{
		String sql = "Select * From hsinlin.Person p Where p.SSN = ?";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
 		ps.setString(1, SSN);
		ResultSet result = ps.executeQuery();
		System.out.println("Before get person, result is " + result);
		while(result.next()) {
			System.out.println("I got person!");
			Person person = new Person();
			person.setSSN(result.getString("SSN"));
			//System.out.println(result.getString("SSN"));
			person.setPassword(result.getString("Password"));
			//System.out.println(result.getString("Password"));
			person.setFirstName(result.getString("FirstName"));
			//System.out.println(result.getString("FirstName"));
			person.setLastName(result.getString("LastName"));
			//System.out.println(result.getString("LastName"));
			person.setStreet(result.getString("Street"));
			//System.out.println(result.getString("Street"));
			person.setCity(result.getString("City"));
			//System.out.println(result.getString("City"));
			person.setState(result.getString("State"));
			//System.out.println(result.getString("State"));
			person.setzip(result.getInt("Zipcode"));
			//System.out.println(result.getInt("Zipcode"));
			person.setTelephone(result.getString("Telephone"));
			//System.out.println(result.getString("Telephone"));
			person.setemail(result.getString("Email"));
			//System.out.println("In search person, ssn is: " + person.getSSN() + " and password is " + person.getpassword());
			return person;
		}
		return null;
	}
	
	//User information
	public static ArrayList<User> viewUsers(Connection connection) throws SQLException{
		String sql = "Select * From hsinlin.User u";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		
		ResultSet result = ps.executeQuery();
		ArrayList<User> userList  = new ArrayList<User>();
		while(result.next()) {
			User user = new User();
			user.setSSN(result.getString("SSN"));
			user.setPPP(result.getString("PPP"));
			user.setRating(result.getInt("Rating"));
			Calendar cc = Calendar.getInstance();
			Date dd = result.getDate("DateOfLastAct");
			cc.setTime(dd);
			user.setLastAct(cc);
			//System.out.println(result.getDate("DateOfLastAct").toString());
			Person p = searchPerson(connection, user.getSSN());
			user.setFirstName(p.getfirstName());
			user.setLastName(p.getLastName());
			user.setemail(p.getemail());
			user.setPassword(p.getpassword());
			user.setStreet(p.getStreet());
			user.setCity(p.getCity());
			user.setState(p.getState());
			user.setzip(p.getzip());
			user.setTelephone(p.gettelephone());
			userList.add(user);	
		}
		return userList;
	}
	
	 
	//Update customer information	
	public static User addCustomer(Connection conn, User usr) throws SQLException{
				
				String sql2 = "Insert into hsinlin.User(SSN, PPP, Rating, DateOfLastAct)"
						      + " values(?, ?, ?, ?)";
				PreparedStatement pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
				pstm2.setString(1, usr.getSSN());
				pstm2.setString(2, usr.getPPP());
				pstm2.setInt(3, usr.getRating());
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date1 = usr.getLastAct().getTime();
				pstm2.setString(4, dateFormat.format(date1));
				pstm2.executeUpdate();
				return usr;
				
		}
		
	public static User updateCustomer(Connection conn, User usr) throws SQLException{
				String sql = "Update hsinlin.Person P"
							+ " Set P.Password = ?, P.FirstName = ?, P.LastName = ?, P.Street = ?, P.City = ?, P.State = ?, P.Zipcode = ?, P.Email = ?, P.Telephone = ?"
							+ " Where P.SSN = ?";
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				System.out.println(usr.gettelephone());
				pstm.setString(1, usr.getpassword());
				pstm.setString(2, usr.getfirstName());
				pstm.setString(3, usr.getLastName());
				pstm.setString(4, usr.getStreet());
				pstm.setString(5, usr.getCity());
				pstm.setString(6, usr.getState());
				pstm.setInt(7, usr.getzip());
				pstm.setString(8, usr.getemail());
				pstm.setString(9, usr.gettelephone());
				
				pstm.setString(10, usr.getSSN());
				
				pstm.executeUpdate();
				
				String sql2 = "Update hsinlin.User U"
						     + " Set U.PPP = ?, U.Rating = ?, U.DateOfLastAct = ?"
						     + " Where U.SSN = ?";
				PreparedStatement pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
				pstm2.setString(4, usr.getSSN());
				pstm2.setString(1, usr.getPPP());
				pstm2.setInt(2, usr.getRating());
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date1 = usr.getLastAct().getTime();
				pstm2.setString(3, dateFormat.format(date1));
				pstm2.executeUpdate();
				System.out.println("update success");
				return usr;
		}
		
	public static User deleteCustomer(Connection conn, User usr) throws SQLException{
				String sql = "Delete From hsinlin.User"
							+ " Where SSN = ?";
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, usr.getSSN());
				pstm.execute();
				
				String sql2 = "DELETE FROM hsinlin.Person"
							+ " Where SSN = ?";
				PreparedStatement pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
				pstm2.setString(1, usr.getSSN());
				pstm2.execute();
				
				pstm.close();
				pstm2.close();
				System.out.println("delete success");
				return usr;
		}

	//Search user (Customer)	
	public static User searchUser (Connection connection, String SSN) throws SQLException {
			String sql = "Select * From hsinlin.User e Where e.SSN = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, SSN);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				User user = new User();
				user.setSSN(result.getString("SSN"));
				user.setPPP(result.getString("PPP"));
				user.setRating(result.getInt("Rating"));
				Calendar cald = Calendar.getInstance();
				Date date = result.getDate("DateOfLastAct");
				cald.setTime(date);
				user.setLastAct(cald);
				
				return user;
			}
			
			return null;
		}
	
	//Account
	public static void insertAccount(Connection connection, Account a) throws SQLException{
		System.out.println("before insert account");
		String sql = "INSERT INTO hsinlin.Account" + "values(?,?,?,?)";
		System.out.println("point0");
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		System.out.println("point1");
		ps.setString(1, a.getSSN());
		ps.setString(2, a.getCardNum());
		ps.setString(3, a.getAccountNum());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = a.getAcctCreationDate().getTime();
		ps.setString(4, dateFormat.format(dd));
		ps.executeUpdate();
		System.out.println("after insert account");
		
	}
	
	//Profiles
	public static void insertProfile(Connection connection, Profile p)throws SQLException {
		String sql = "INSERT INTO hsinlin.Profile" + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setString(1, p.getProfileID());
		ps.setString(2, p.getOwnerSSN());
		ps.setInt(3, p.getAge());
		ps.setInt(4, p.getDatingAgeRangeStart());
		ps.setInt(5, p.getDatingAgeRangeEnd());
		ps.setInt(6, p.getDatingGeoRange());
		ps.setString(7,p.getGender());
		ps.setString(8,p.getHobbies()); 
		ps.setDouble(9, p.getHeight());
		ps.setDouble(10, p.getWeight());
		ps.setString(11, p.getHairColor());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = p.getCreationDate().getTime();
		ps.setString(12, dateFormat.format(dd));
		Date d = p.getLastModDate().getTime();
		ps.setString(13,dateFormat.format(d));
		
		ps.executeUpdate();
	}
	
	
	public static Profile updateProfile(Connection conn, Profile profile) throws SQLException{
		String sql = "Update hsinlin.Profile P"
				+ " Set P.ProfileID = ?, P.Age = ?, P.DatingAgeRangeStart = ?, P.DatingAgeRangeEnd = ?, P.Gender = ?, P.Hobbies = ?, P.Height = ?, P.Weight = ?, P.HairColor = ?, P.CreationDate = ?, P.LastModDate = ?, P.DatingGeoRange = ?"
				+ " Where P.OwnerSSN = ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, profile.getProfileID());
		pstm.setInt(2, profile.getAge());
		pstm.setInt(3, profile.getDatingAgeRangeStart());
		pstm.setInt(4, profile.getDatingAgeRangeEnd());
		pstm.setString(5, profile.getGender());
		pstm.setString(6, profile.getHobbies());
		pstm.setDouble(7, profile.getHeight());
		pstm.setDouble(8, profile.getWeight());
		pstm.setString(9, profile.getHairColor());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = profile.getCreationDate().getTime();
		pstm.setString(10, dateFormat.format(date1));
		
		Date date2 = profile.getLastModDate().getTime();
		pstm.setString(11, dateFormat.format(date2));
		
		pstm.setInt(12, profile.getDatingGeoRange());
		pstm.setString(13, profile.getOwnerSSN());
		
		pstm.executeUpdate();
		return profile;
	}
	
	
	public static Profile deleteProfile(Connection conn, Profile profile) throws SQLException{
		String sql = "DELETE FROM hsinlin.Profile" 
					+ " WHERE OwnerSSN = ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, profile.getOwnerSSN());
		pstm.execute();
		pstm.close();
		return profile;
		
	}
	

	public static Profile searchProfile(Connection connection, String profileID) throws SQLException {
		String sql = "Select * From hsinlin.Profile P Where P.ProfileID = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		pstm.setString(1, profileID);
		
		ResultSet rs = pstm.executeQuery();
		
		//if (!rs.next()) {
		//	System.out.println("cannot found");
		//	return null;
		//}
		if(rs.next()) {
		Profile p = new Profile();
		p.setAge(rs.getInt("Age"));
		p.setProfileID(profileID);
		
		p.setOwnerSSN(rs.getString("OwnerSSN"));
		
		Date dat = rs.getDate("CreationDate");
		Calendar c = Calendar.getInstance();
		c.setTime(dat);
		p.setCreationDate(c);
		
		p.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeStart"));
		p.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
		
		p.setGender(rs.getString("Gender"));
		p.setHobbies(rs.getString("Hobbies"));
		
		p.setHeight(rs.getDouble("Height"));
		p.setWeight(rs.getInt("Weight"));
		
		p.setHairColor(rs.getString("HairColor"));
		
		Date date = rs.getDate("LastModDate");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		p.setLastModDate(c1);
		
		p.setDatingGeoRange(rs.getInt("DatingGeoRange"));
		System.out.println("profile id is " + profileID + " age is: " + p.getAge() 
						 + " height is: " + p.getHeight() + " weight is: " + p.getWeight());

		return p;
		}
		else {
			return null;
		}
	}
	

}
