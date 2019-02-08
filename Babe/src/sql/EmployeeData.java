package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javabeans.Dates;
import javabeans.Employee;
import javabeans.MailingList;
import javabeans.Person;
import javabeans.Profile;
import javabeans.User;


public class EmployeeData {
	
	//Update employee information
	public static void insertEmployee(Connection connection, Employee employee) throws SQLException {
		String sql1 = "insert into hsinlin.Person(SSN,Password,FirstName,LastName,Street,City,State,Zipcode,Email,Telephone)" 
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = (PreparedStatement)connection.prepareStatement(sql1);
		
		pstm.setString(2, employee.getpassword());
		pstm.setString(3, employee.getfirstName());
		pstm.setString(4, employee.getLastName());
		pstm.setString(5, employee.getStreet()); 
		pstm.setString(6, employee.getCity());
		pstm.setString(7, employee.getState());
		pstm.setInt(8, employee.getzip());
		pstm.setString(10, employee.gettelephone());
		pstm.setString(9, employee.getemail());
		pstm.setString(1, employee.getSSN());
		
		pstm.executeUpdate();
		
		String sql = "insert into hsinlin.Employee(SSN,Role,StartDate,HourlyRate)" + " values(?,?,?,?)";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date theday = employee.getStartDate().getTime();
		//Calendar c = employee.getStartDate();
		
		ps.setString(1, employee.getSSN());
		ps.setString(2, employee.getRole());
		ps.setString(3, dateFormat.format(theday));
		ps.setInt(4, employee.getHourlyRate());
		
		ps.executeUpdate();
		
	}
	
	public static Employee searchEmployee (Connection connection, String SSN) throws SQLException {
		String sql = "Select * From hsinlin.Employee e Where e.SSN = ?";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		
		
		
		ps.setString(1, SSN);
		ResultSet result = ps.executeQuery();
		
		//if (!result.next()) {
		//	System.out.println("cannot found");
		//	return null;
		//}
		
		System.out.println("reach before while");
		while(result.next()) {
			System.out.println("reach here");
			Employee empl = new Employee();
			empl.setSSN(result.getString("SSN"));
			empl.setRole(result.getString("Role"));
			Date d = result.getDate("StartDate");
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			empl.setStartDate(c);
			empl.setHourlyRate(result.getInt("HourlyRate"));
			
			return empl;
		}
		System.out.println("return null");
		return null;
	}
	
	//Update an employee
	public static Employee updateEmployee(Connection conn, Employee em) throws SQLException{
				
			String sql = "Update hsinlin.Person P"
						+ " Set P.Password = ?, P.FirstName = ?, P.LastName = ?, P.Street = ?, P.City = ?, P.State = ?, P.Zipcode = ?, P.Email = ?, P.Telephone = ?"
						+ " Where P.SSN = ?";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		   
			pstm.setString(1, em.getpassword());
			pstm.setString(2, em.getfirstName());
			pstm.setString(3, em.getLastName());
			pstm.setString(4, em.getStreet());
			pstm.setString(5, em.getCity());
			pstm.setString(6, em.getState());
			pstm.setInt(7, em.getzip());
			pstm.setString(8, em.getemail());
			pstm.setString(9, em.gettelephone());
			pstm.setString(10, em.getSSN());
			pstm.execute();
			System.out.println("update employee success!");
			
			String sql2 = "Update hsinlin.Employee E"
						+ " Set E.Role = ?, E.StartDate = ?, E.HourlyRate = ?"
					+ " Where E.SSN = ?";
			PreparedStatement pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
			
		
			pstm2.setString(1, em.getRole());

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = em.getStartDate().getTime();
			pstm2.setString(2, dateFormat.format(date1));		
			pstm2.setInt(3, em.getHourlyRate());
			pstm2.setString(4, em.getSSN());				
			pstm2.execute();
			pstm.close(); 
			pstm2.close();
		    System.out.println("success");			
			return em;
		}
	
	public static Employee updateEmployeeSelf(Connection conn, Employee em) throws SQLException{
		
		String sql = "Update hsinlin.Person P"
					+ " Set P.Password = ?, P.FirstName = ?, P.LastName = ?, P.Street = ?, P.City = ?, P.State = ?, P.Zipcode = ?, P.Email = ?, P.Telephone = ?"
					+ " Where P.SSN = ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			
		pstm.setString(1, em.getpassword());
		pstm.setString(2, em.getfirstName());
		pstm.setString(3, em.getLastName());
		pstm.setString(4, em.getStreet());
		pstm.setString(5, em.getCity());
		pstm.setString(6, em.getState());
		pstm.setInt(7, em.getzip());
		pstm.setString(8, em.getemail());
		pstm.setString(9, em.gettelephone());
		pstm.setString(10, em.getSSN());
		pstm.execute();
		System.out.println("update employee success!");
		pstm.close(); 

	    System.out.println("success");			
		return em;
	}
	
	//Delete the employee
	public static Employee deleteEmployee(Connection conn, Employee em) throws SQLException{
			String SSN = em.getSSN();
			String sql = "DELETE FROM hsinlin.Employee" 
						+ " WHERE SSN = ?";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, SSN);
			pstm.execute();
			
			String sql2 = "DELETE FROM hsinlin.Person"
						+ " Where SSN = ?";
			PreparedStatement pstm2 = (PreparedStatement) conn.prepareStatement(sql2);
			pstm2.setString(1, SSN);
			pstm2.execute();
			
			pstm.close();
			pstm2.close();
			System.out.println("Already delete");
			
			return em;
		} 
		
	public static boolean isManager(Connection connection, Employee employee) throws SQLException {
		if(employee.getRole().equals("CustRep")) {
			return true;
			}
		
		else
			return false;
	}

	public static Employee searchCRByRevenue(Connection conn) throws SQLException {
		String sql = "Select E.SSN, E.role, E.startDate, E.hourlyRate"
					  + " From hsinlin.Employee E, hsinlin.Date D" 
					  + " Where D.CustRep = E.SSN GROUP BY E.SSN" 
					  + " ORDER BY SUM(BookingFee) DESC"
					  + " LIMIT 1";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
	    
		Employee e = new Employee();
	    rs.next();
		e.setSSN(rs.getString("SSN"));
		System.out.println(rs.getString("SSN"));
		e.setHourlyRate(rs.getInt("hourlyRate"));
		System.out.println(rs.getInt("hourlyRate"));
		e.setRole("CustRep");
		Date date = rs.getDate("startDate");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		e.setStartDate(c);
		System.out.println(rs.getDate("startDate"));
		
		return e;
	}
	
	//Produce a list of top 3 active customers
	public static ArrayList<Profile> searchActiveUser(Connection conn) throws SQLException{
		String sql = "Select *" 
					+ " From hsinlin.Profile P"
					+ " Order BY 'DateOfLastAct' DESC" 
					+ " LIMIT 3";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		ArrayList<Profile> p = new ArrayList<Profile>();
		
		while(rs.next()) {
			Profile pro = new Profile();
			pro.setAge(rs.getInt("Age"));
			System.out.println(rs.getInt("Age"));
			
			
			Date date = rs.getDate("CreationDate");
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			pro.setCreationDate(c);
			System.out.println(rs.getDate("CreationDate"));
			
			pro.setDatingAgeRangeStart(rs.getInt("DatingAgeRangeStart"));
			System.out.println(rs.getInt("DatingAgeRangeStart"));
			
			pro.setDatingAgeRangeEnd(rs.getInt("DatingAgeRangeEnd"));
			System.out.println(rs.getInt("DatingAgeRangeEnd"));
			
			pro.setDatingGeoRange(rs.getInt("DatingGeoRange"));
			System.out.println(rs.getInt("DatingGeoRange"));
			
			pro.setGender(rs.getString("Gender"));
			System.out.println(rs.getString("Gender"));
			
			pro.setHairColor(rs.getString("HairColor"));
			System.out.println(rs.getString("HairColor"));
			
			pro.setHeight(rs.getDouble("Height"));
			System.out.println(rs.getDouble("Height"));
			
			pro.setHobbies(rs.getString("Hobbies"));
			System.out.println(rs.getString("Hobbies"));
			
			
			Date dat = rs.getDate("LastModDate");
			Calendar ca = Calendar.getInstance();
			ca.setTime(dat);
			pro.setLastModDate(ca);
			System.out.println(rs.getDate("LastModDate"));
			
			pro.setOwnerSSN(rs.getString("OwnerSSN"));
			System.out.println(rs.getString("OwnerSSN"));
			
			pro.setProfileID(rs.getString("ProfileID"));
			System.out.println(rs.getString("ProfileID"));
			
			pro.setWeight(rs.getInt("Weight"));
			System.out.println(rs.getInt("Weight"));
			
			System.out.println("END OF THE PROFILE");
			
			p.add(pro);
				
		}
		return p;
	}
	
	//Produce a list of the highest-rated customers????
	public static ArrayList<User> searchHighestRatedUser(Connection conn) throws SQLException{
		String sql = "Select *" 
					+ " From hsinlin.User U" 
					+ " ORDER BY U.Rating DESC" 
					+ " LIMIT 3";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		ArrayList<User> usr = new ArrayList<User>();
		while(rs.next()) {
			User u = new User();
			u.setSSN(rs.getString("SSN"));
			System.out.println(rs.getString("SSN"));
			
			u.setPPP(rs.getString("PPP"));
			System.out.println(rs.getString("PPP"));
			
			u.setRating(rs.getInt("Rating"));
			System.out.println(rs.getInt("Rating"));
			
			Date date = rs.getDate("DateOfLastAct");
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			u.setLastAct(c);
			System.out.println(rs.getDate("DateOfLastAct"));
			
			usr.add(u);
				
		}
		return usr;
	}


	public static ArrayList<MailingList> produceMailingList(Connection conn) throws SQLException{
			String sql = "Select S.FirstName, S.LastName, S.Street, S.City, S.State, S.Zipcode"
					+ " From Person S, User U"
					+ " Where U.SSN = S.SSN";
			
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<MailingList> mailList = new ArrayList<MailingList>();
			
			while(rs.next()) {
				MailingList mail = new MailingList();
				mail.setFirstName(rs.getString("FirstName"));
				mail.setLastName(rs.getString("LastName"));
				mail.setStreet(rs.getString("Street"));
				mail.setCity(rs.getString("city"));
				mail.setState(rs.getString("state"));
				mail.setZipCode(rs.getString("zipCode"));
				
				mailList.add(mail);
			}
			
			for (MailingList m : mailList) {
				
				System.out.println(m.getFirstName() + " " + m.getLastName());
			}
			return mailList;
			
	}
	
	//Make a geo-date
	public static Dates makeAGeoDate(Connection conn, Dates dates) throws SQLException{
			String sql = "Insert into Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee, Comments, User1Rating, User2Rating)"
						+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, dates.getProfile1());
			pstm.setString(2, dates.getProfile2());
			pstm.setString(3, dates.getCustRep());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = dates.getDateTime().getTime();
			
			pstm.setString(4, dateFormat.format(date1));
			pstm.setString(5, dates.getLocation());
			pstm.setDouble(6, dates.getBookingFee());
			pstm.setString(7, dates.getComments());
			pstm.setInt(8, dates.getUser1Rating());
			pstm.setInt(9, dates.getUser2Rating());
			pstm.executeUpdate();
			
			return dates;
	}
	
	//Employee information
		public static ArrayList<Employee> viewEmployees(Connection connection) throws SQLException{
			String sql = "Select * From hsinlin.Employee e";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			
			ResultSet result = ps.executeQuery();
			ArrayList<Employee> empList  = new ArrayList<Employee>();
			while(result.next()) {
				Employee emp = new Employee();
				emp.setSSN(result.getString("SSN"));
				emp.setRole(result.getString("Role"));
				emp.setHourlyRate(result.getInt("HourlyRate"));
				Calendar cc = Calendar.getInstance();
				Date dd = result.getDate("StartDate");
				cc.setTime(dd);
				emp.setStartDate(cc);
				//System.out.println(result.getDate("DateOfLastAct").toString());
				Person p = UsersData.searchPerson(connection, emp.getSSN());
				emp.setFirstName(p.getfirstName());
				emp.setLastName(p.getLastName());
				emp.setemail(p.getemail());
				emp.setPassword(p.getpassword());
				emp.setStreet(p.getStreet());
				emp.setCity(p.getCity());
				emp.setState(p.getState());
				emp.setzip(p.getzip());
				emp.setTelephone(p.gettelephone());
				empList.add(emp);	
			}
			return empList;
		}
	
}
