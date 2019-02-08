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
import javabeans.Profile;
import javabeans.User;
import javabeans.salesReport;;

public class SaleData {
	//Modified
		public static ArrayList<Dates> getSaleByDate(Connection connection, Calendar day1, Calendar day2) throws SQLException {
			String sql = "Select d.BookingFee, d.Profile1, d.Profile2, d.CustRep" +
						 " From hsinlin.Date d" 
						 +" Where d.Date_Time BETWEEN ? AND ?";
			
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   
			Date date1 = day1.getTime();
			Date date2 = day2.getTime();
			ps.setString(1, dateFormat.format(date1));
			ps.setString(2, dateFormat.format(date2));
			System.out.println(dateFormat.format(date1));
			System.out.println(dateFormat.format(date2));
			
			ResultSet result = ps.executeQuery();
			ArrayList<Dates> saleBydate = new ArrayList<Dates>();
			while(result.next()) {
				Dates d = new Dates();
				d.setCustRep(result.getString("CustRep"));
				System.out.println(result.getString("CustRep"));
				d.setProfile1(result.getString("Profile1"));
				System.out.println(result.getString("Profile1"));
				d.setProfile2(result.getString("Profile2"));
				System.out.println(result.getString("Profile2"));
				d.setBookingFee(result.getInt("BookingFee"));
				System.out.println(result.getString("BookingFee"));
				saleBydate.add(d);
			}
			return saleBydate;
		}
		
		public static ArrayList<Dates> getSaleByCust(Connection connection, String Cust) throws SQLException {
			String sql = "Select d.BookingFee, d.Profile1, d.Profile2, d.CustRep" +
						  " From hsinlin.Date d" 
						+ " Where d.Profile1 = ? or d.Profile2 = ?";
			
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			
			ps.setString(1, Cust);
			ps.setString(2, Cust);
			ResultSet result = ps.executeQuery();
			System.out.println("after result set");
			ArrayList<Dates> saleByCust = new ArrayList<Dates>();
			while(result.next()) {
				System.out.println("in result.next");
				Dates d = new Dates();
				d.setCustRep(result.getString("CustRep"));
				System.out.println(result.getString("CustRep"));
				d.setProfile1(result.getString("Profile1"));
				System.out.println(result.getString("Profile1"));
				d.setProfile2(result.getString("Profile2"));
				System.out.println(result.getString("Profile2"));
				d.setBookingFee(result.getDouble("BookingFee"));
				System.out.println(result.getDouble("BookingFee"));
				saleByCust.add(d);
			} 
			return saleByCust;
		} 
		
		public static ArrayList<salesReport> searchSalesReport(Connection conn, Calendar startDate, Calendar endDate) throws SQLException{
			   //System.out.println(startDate.toString());
			   String sql = "Select D.Profile1, D.Profile2, D.Date_Time, D.BookingFee, D.CustRep"
					   		+ " FROM hsinlin.Date D"
					        + " Where D.Date_Time BETWEEN ? AND ?";
			   PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			   
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   
			   Date date1 = startDate.getTime();
			   Date date2 = endDate.getTime();
			   
			   
			   pstm.setString(1, dateFormat.format(date1));
			   pstm.setString(2, dateFormat.format(date2));
			   System.out.println(date1);
			   System.out.println(date2);
			   ResultSet rs = pstm.executeQuery();
			   
			   ArrayList<salesReport> rep = new ArrayList<salesReport>();
			   
			   System.out.println("Before while sale report");
			   while(rs.next()) {
				   salesReport report = new salesReport();
				   report.setCustRepSSN(rs.getString("CustRep"));
				   System.out.println(rs.getString("CustRep"));
				   
				   report.setFees(rs.getInt("BookingFee"));
				   System.out.println(rs.getInt("BookingFee"));
				   
				   report.setProfileA(rs.getString("Profile1"));
				   System.out.println(rs.getString("Profile1"));
				   
				   report.setProfileB(rs.getString("Profile2"));
				   System.out.println(rs.getString("Profile2"));
				   
				   
				   Date date = rs.getDate("Date_Time");
				   Calendar c = Calendar.getInstance();
				   c.setTime(date);
				   report.setDate(c);
				   System.out.println(c.getTime());
				   
				   rep.add(report);
				   System.out.println("in while");
				  
			  }
			  return rep;
		}
		
		public static void insertSaleData(Connection connection, salesReport report) throws SQLException {
			String sql = "insert into hsinlin.salesReport(CustRepSSN,ProfileA,ProfileB,fees,date)" + " values(?,?,?,?,?)";
			
			PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
			
			ps.setString(1,report.getCustRepSSN());
			ps.setString(2, report.getProfileA());
			ps.setString(3, report.getProfileB());
			ps.setInt(4, report.getFees());
			ps.setString(5, report.getDate().getTime().toString());       //////////////////make into String?/////////////////////
			
			ps.executeUpdate();
			
		}
		
		public static salesReport searchSaleData (Connection connection, salesReport saleReport) throws SQLException {
			String sql = "Select * From hsinlin.Date d Where d.CustRep = ? And Profile1 = ? And Profile2 = ?";
			
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			
			ps.setString(1, saleReport.getCustRepSSN());
			ps.setString(2, saleReport.getProfileA());
			ps.setString(3, saleReport.getProfileB());
			
			
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				salesReport salerep = new salesReport();
				salerep.setCustRepSSN(result.getString("CustRep"));
				salerep.setProfileA(result.getString("Profile1"));
				salerep.setProfileB(result.getString("Profile2"));
				salerep.setFees(result.getInt("BookingFee"));
				Date theday = result.getDate("Date_Time");
				Calendar c = Calendar.getInstance();
				c.setTime(theday);
				salerep.setDate(c);		
				return salerep;
			}
			
			return null;
		}
		
		public static Profile mostSpend(Connection connection) throws SQLException {
			String sql = "Select p.OwnerSSN, p.ProfileID" 
						+ " From Profile p, Date D" 
						+ " Where p.ProfileID = d.Profile1 or p.ProfileID = d.Profile2" 
						+ " Group By p.OwnerSSN" + 
						" Order By SUM(BookingFee)DESC Limit 1";
			
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			System.out.println("before result");
			ResultSet result = ps.executeQuery();
			System.out.println("after result");
			Profile temp = new Profile();
			result.next();
			temp.setOwnerSSN(result.getString("OwnerSSN"));
			temp.setProfileID(result.getString("ProfileID"));
			
			return temp;
		}
}
