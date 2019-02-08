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
import javabeans.Profile;

public class DateInfo { 
	
	public static void insertDates(Connection connection, Dates date) throws SQLException{
		String sql = "INSERT into hsinlin.Date(Profile1, Profile2, CustRep, Date_Time, Location, BookingFee,  Comments, User1Rating, User2Rating)" 
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = date.getDateTime().getTime();

		ps.setString(1, date.getProfile1());
		ps.setString(2, date.getProfile2());
		ps.setString(3, date.getCustRep());
		ps.setString(4, dateFormat.format(d));
		ps.setString(5, date.getLocation());
		ps.setDouble(6, date.getBookingFee());
		ps.setString(7, date.getComments());
		ps.setInt(8, date.getUser1Rating());	
		ps.setInt(9, date.getUser2Rating());	
		ps.executeUpdate();
		ps.close();
	}
	//Record a date
	public static void recordDates(Connection conn, Dates dates) throws SQLException{
			
			String sql = "Update hsinlin.Date D" 
						+ " Set D.BookingFee = ?, D.CustRep = ?, D.Location = ?" 
						+ " Where D.Profile1 = ? AND D.Profile2 = ?"
						+ " AND D.Date_Time = ?";
			
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setDouble(1, dates.getBookingFee());
		pstm.setString(2, dates.getCustRep());
		pstm.setString(3, dates.getLocation());
		pstm.setString(4, dates.getProfile1());
		pstm.setString(5, dates.getProfile2());
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = dates.getDateTime().getTime();
		pstm.setString(6, dateFormat.format(date1));
		System.out.println(dateFormat.format(date1));
		pstm.executeUpdate();
		System.out.println("after update");
		pstm.close();
		//return dates;			
		}
	
	public static Dates searchDate(Connection conn, String profile1, String profile2, Calendar Date_Time)throws SQLException{
		String sql = "Select * From hsinlin.Date D Where D.Profile1 = ? AND D.Profile2 = ? AND D.Date_Time = ?";

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 		ps.setString(1, profile1);
 		ps.setString(2, profile2);
 		ps.setString(3, dateFormat.format(Date_Time.getTime()));
 		
 		//System.out.println(dateFormat.format(Date_Time.getTime()));
 		
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			Dates date = new Dates();
			date.setProfile1(result.getString("Profile1"));
			date.setProfile2(result.getString("Profile2"));
			date.setCustRep(result.getString("CustRep"));
			Calendar cal = Calendar.getInstance();
			cal.setTime(result.getDate("Date_Time"));
			date.setDateTime(cal);
			date.setLocation(result.getString("Location"));
			date.setBookingFee(result.getDouble("BookingFee"));
			date.setComments(result.getString("Comments"));
			date.setUser1Rating(result.getInt("User1Rating"));
			date.setUser2Rating(result.getInt("User2Rating"));
			
			return date;
		}
		return null;
	}

	//Cancel date
	public static void cancelDates(Connection conn, String profile1, String profile2, Calendar Date_Time) throws SQLException{
        String sql = "DELETE FROM hsinlin.Date "
        		+ "WHERE profile1 = ? AND profile2 = ? AND Date_Time = ?";
 
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date cancelD = Date_Time.getTime();

	    //System.out.println(dateFormat.format(cancelD));
        
        ps.setString(1, profile1);
        ps.setString(2, profile2);
        ps.setString(3, dateFormat.format(cancelD));
            // execute the delete statement
            ps.execute();
	}
	
	public static void updateComment(Connection conn, Dates updatedDate, String comment) throws SQLException{
		
    	String sql = "UPDATE hsinlin.Date D SET D.Comments = ? WHERE D.Profile1 = ? AND D.Profile2 = ? AND D.Date_Time = ?";
    	PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateD = updatedDate.getDateTime().getTime();

		ps.setString(1, comment);
    	ps.setString(2, updatedDate.getProfile1());
		ps.setString(3, updatedDate.getProfile2());
		ps.setString(4, dateFormat.format(updateD));
		ps.executeUpdate();
		
		ps.close();
    }
	
	//Update date rating
	public static void updateDateRating(Connection connection, Dates date, int rateA, int rateB) throws SQLException {
		String sql = "UPDATE hsinlin.Date D SET D.User1Rating = ?, D.User2Rating = ? WHERE D.Profile1 = ? AND D.Profile2 = ? AND D.Date_Time = ?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateD = date.getDateTime().getTime();
        
        ps.setInt(1, rateA);
        ps.setInt(2, rateB);
        ps.setString(3, date.getProfile1());
        ps.setString(4, date.getProfile2());
        ps.setString(5, dateFormat.format(updateD));
        
        ps.close();
	}
	
	public static ArrayList<Profile> datedWho(Connection connection, Dates profID) throws SQLException{
		String sql = "Select P.ProfileID From Profile P, Date D Where (D.Profile1 = ? AND D.Profile2 = P.ProfileID) OR (D.Profile2 = ? AND D.Profile1 = P.ProfileID" + 
				" values(?,?)";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
		ps.setString(1, profID.getProfile1());
		ps.setString(4, profID.getProfile2());
		ArrayList<Profile> datewho = new ArrayList<Profile>();
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			Profile prof = new Profile();
			prof.setProfileID(result.getString("ProfileID"));
			datewho.add(prof);
		} 

		return datewho;
	}
	
	public static ArrayList<Calendar> goodDayforDate (Connection connection) throws SQLException{
		String sql = "Select Cast (D.Date_Time As date) From Date D Order By D.Date_Time DESC Limit 3";
		
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
		
		ArrayList<Calendar> niceDays = new ArrayList<Calendar>();
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			Calendar cald = Calendar.getInstance();
			Date date = result.getDate("Date_Time");
			cald.setTime(date);
			niceDays.add(cald); 
		}
		
		return niceDays; 
	}
	
	//Modified
	public static ArrayList<Dates> searchDatesByDate(Connection conn, Calendar dateA, Calendar dateB) throws SQLException {
		String sql = "Select *"
				+ " From hsinlin.Date D"
		        + " Where D.Date_Time BETWEEN ? AND ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   
		Date date1 = dateA.getTime();
		Date date2 = dateB.getTime();
		pstm.setString(1, dateFormat.format(date1));
		pstm.setString(2, dateFormat.format(date2));
		
		System.out.println(dateFormat.format(date1));
		System.out.println(dateFormat.format(date2));
		
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<Dates> dates = new ArrayList<Dates>();
		
		System.out.println("here");
		
		
		while(rs.next()) {
			Dates d = new Dates();
			d.setComments(rs.getString("Comments"));
			System.out.println(rs.getString("Comments"));
			
			d.setCustRep(rs.getString("CustRep"));
			System.out.println(rs.getString("CustRep"));
			
			
			Date dat = rs.getDate("Date_Time");
			Calendar c = Calendar.getInstance();
			c.setTime(dat);
			d.setDateTime(c);
			System.out.println(rs.getDate("Date_Time"));
			
			d.setLocation(rs.getString("Location"));
			System.out.println(rs.getString("Location"));
			
			d.setProfile1(rs.getString("Profile1"));
			System.out.println(rs.getString("Profile1"));
			
			d.setProfile2(rs.getString("Profile2"));
			System.out.println(rs.getString("Profile2"));
			
			d.setUser1Rating(rs.getInt("User1Rating"));
			System.out.println(rs.getInt("User1Rating"));
			
			d.setUser2Rating(rs.getInt("User2Rating"));
			System.out.println(rs.getInt("User2Rating"));
			
			d.setBookingFee(rs.getDouble("BookingFee"));
			System.out.println(rs.getDouble("BookingFee"));
			dates.add(d);
			//return dates;
		}
		return dates;
}

	public static ArrayList<Dates> searchByName(Connection conn, String name) throws SQLException{
		String sql = "Select *" 
					+ " From Date D" 
					+ " Where D.Profile1 = ? OR D.Profile2 = ?";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, name);
		ResultSet rs = pstm.executeQuery();
		ArrayList<Dates> dates = new ArrayList<Dates>();
		
		while(rs.next()) {
			Dates d = new Dates();
			d.setComments(rs.getString("Comments"));
			System.out.println(rs.getString("Comments"));
			
			d.setCustRep(rs.getString("CustRep"));
			System.out.println(rs.getString("CustRep"));
			
			
			Date date = rs.getDate("Date_Time");
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			d.setDateTime(c);
			System.out.println(rs.getDate("Date_Time"));
			
			d.setLocation(rs.getString("Location"));
			System.out.println(rs.getString("Location"));
			
			d.setProfile1(rs.getString("Profile1"));
			System.out.println(rs.getString("Profile1"));
			
			d.setProfile2(rs.getString("Profile2"));
			System.out.println(rs.getString("Profile2"));
			
			d.setUser1Rating(rs.getInt("User1Rating"));
			System.out.println(rs.getInt("User1Rating"));
			
			d.setUser2Rating(rs.getInt("User2Rating"));
			System.out.println(rs.getInt("User2Rating"));
			
			
			dates.add(d);
		}
		return dates;	
	}
	
}
