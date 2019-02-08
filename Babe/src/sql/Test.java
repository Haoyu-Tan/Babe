package sql;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javabeans.Dates;
import javabeans.Employee;
import javabeans.Profile;
import javabeans.User;
import sql.SqlConnection;
import sql.EmployeeData;
import sql.UsersData;
import sql.DateInfo;



public class Test { 
	
	
	public static void main(String[] args) throws Exception {
		
		SqlConnection dd = new SqlConnection();
		dd.readDatabase();
		EmployeeData ed = new EmployeeData();
		UsersData ud = new UsersData();
		DateInfo di = new DateInfo();
		
		
		
		//Date today = new Date(2018, 4, 24);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH, 6);
		cal.set(Calendar.HOUR_OF_DAY, 21);
		cal.set(Calendar.MINUTE, 49);
		cal.set(Calendar.MILLISECOND, 30);
		Date dateRepresentation = cal.getTime();
	    //System.out.println(dateFormat.format(dateRepresentation));
		
	    Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 2014);
		cal1.set(Calendar.MONTH, Calendar.OCTOBER);
		cal1.set(Calendar.DAY_OF_MONTH, 30);
		Date date1 = cal1.getTime();
	    //System.out.println(dateFormat.format(date1));
		
		//ed.searchDatesByDate(dd.getConnected(), cal);
		
		Employee em = new Employee();
		em.setCity("SBU");
		em.setemail("em@gmail.com");
		em.setFirstName("em");
		em.setLastName("whatEver");
		em.setHourlyRate(130);
		em.setPassword("suri.1234");
		em.setRole("Manager");
		em.setSSN("222-22-2222");
		Calendar cal2 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 2017);
		cal1.set(Calendar.MONTH, Calendar.MAY);
		cal1.set(Calendar.DAY_OF_MONTH, 19);
		em.setStartDate(cal1);
		em.setState("NY");
		em.setStreet("347");
		em.setTelephone("631-222-2222");
		em.setzip(11790);
		ed.insertEmployee(dd.getConnected(), em);
		
		//ed.deleteEmployee(dd.getConnected(), em);
		
		Dates dates = new Dates();
		dates.setBookingFee(30.14);
		dates.setComments("Totally wasting my time");
		dates.setCustRep("suri");
		dates.setDateTime(cal1);
		dates.setLocation("Rest Room");
		dates.setProfile1("Brenna Berline");
		dates.setProfile2("DesiraeBera");
		dates.setUser1Rating(1);
		dates.setUser2Rating(4);
		//ed.recordDates(dd.getConnected(), dates);
		
		User usr = new User();
		usr.setCity("Stony Brook");
		usr.setemail("hhh@gmail.com");
		usr.setFirstName("HHHJJ");
		usr.setLastName("IHateSQL");
		
		usr.setLastAct(cal1);
		usr.setPassword("123@qqq");
		usr.setPPP("Good-User");
		usr.setRating(4);
		usr.setSSN("888-66-8866");
		usr.setState("NY");
		usr.setStreet("Great Neck Rd");
		usr.setTelephone("(667)66-6666");
		usr.setzip(11790);
		ud.updateCustomer(dd.getConnected(), usr);
		
		
		Profile prof = new Profile();
		prof.setAge(21);
		prof.setProfileID("Lalula");
		prof.setCreationDate(Calendar.getInstance());
		prof.setDatingAgeRangeEnd(20);
		prof.setDatingAgeRangeStart(18);
		prof.setDatingGeoRange(20);
		prof.setGender("Male");
		prof.setHairColor("Black");
		prof.setHeight(6.6);
		prof.setOwnerSSN("888-66-8866");
		prof.setHobbies("Dance, Gardening");
		prof.setWeight(160);
		prof.setLastModDate(Calendar.getInstance());
		//ud.insertProfile(dd.getConnected(), prof); 
		
		/*ArrayList<String> list = cv.myFavorite(dd.getConnected(), prof);
		for(String i : list) {
			System.out.println(i);
		}*/
		
		
		// Search according is not working properly
		/*ArrayList<Profile> slist = cv.searchAccording(dd.getConnected(), "New York", "Blond", 0, 0);
		for(Profile p : slist) {
			System.out.println(p.getProfileID());
		}*/
		
		//ud.deleteProfile(dd.getConnected(),prof);
		// Update Date
		Calendar cld = Calendar.getInstance();
		//cld.set(2018, 3, 26, 14, 22, 02);
		cld.set(Calendar.YEAR, 2018);
		cld.set(Calendar.MONTH, Calendar.APRIL);
		cld.set(Calendar.DAY_OF_MONTH, 26);
		cld.set(Calendar.HOUR_OF_DAY, 14);
		cld.set(Calendar.MINUTE, 22);
		cld.set(Calendar.SECOND, 02);
		
		Dates dt = new Dates();
		dt.setBookingFee(103.55);
		dt.setComments("WAT");
		dt.setCustRep("444-44-4444");
		dt.setDateTime(cld);
		dt.setLocation("Restroom");
		dt.setProfile1("Brenna_Berlin");
		dt.setProfile2("Fletcher_Trujillo");
		dt.setUser1Rating(4);
		dt.setUser2Rating(3);
		di.recordDates(dd.getConnected(), dt);
		
		//Profile temp = cv.mostActiveProf(dd.getConnected());
		//System.out.println(temp.getProfileID());
		
		//temp = cv.bestProf(dd.getConnected());
		//System.out.println(temp.getProfileID());
		
		
		
		
	}
}
