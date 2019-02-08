package sql;

import javabeans.Profile;
import javabeans.User;
import javabeans.locationRate;
import javabeans.Person;
import javabeans.Likes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javabeans.Dates;

public class CustViews {
	
	public static ArrayList<String> myFavorite(Connection connection, Profile prof) throws SQLException{
		String sql = "Select P.ProfileID From Profile P, Likes L Where L.Liker=? And P.ProfileID=L.Likee";
		
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setString(1, prof.getProfileID());
		ResultSet rs = ps.executeQuery();
		ArrayList<String> favoriteList = new ArrayList<String>();
		while(rs.next()) {
			favoriteList.add(rs.getString("ProfileID"));			
		}
		return favoriteList;
		
	}
	
	public static ArrayList<Profile> searchAccording (Connection connection, String location, String hairColor, double height, int weight) throws SQLException{
		String sql = "Select * From Profile P, Person S Where(S.City=? Or P.HairColor = ? Or P.Height = ? Or P.Weight = ?) And S.SSN = P.OwnerSSN";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		
		ps.setString(1,location);
		ps.setString(2, hairColor);
		ps.setDouble(3, height);
		ps.setInt(4, weight);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Profile> prof = new ArrayList<Profile>(); 
		
		while(rs.next()) {
			Profile temp = new Profile();
			//can't set city(location) for profile
			temp.setProfileID(rs.getString("ProfileID"));
			temp.setHairColor(rs.getString("HairColor"));
			temp.setHeight(rs.getDouble("Height"));
			temp.setWeight(rs.getInt("Weight"));
			prof.add(temp);
		}
		
		return prof;
	}
	
	public static ArrayList<Profile> mostActiveProf(Connection connection) throws SQLException{
		String sql = "Select * From Profile P Order By LastModDate DESC Limit 3";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Profile> po = new ArrayList<Profile>();
		while(rs.next()) {
			Profile activer = new Profile();
			activer.setProfileID(rs.getString("ProfileID"));
			activer.setAge(rs.getInt("Age"));
			activer.setGender(rs.getString("Gender"));
			activer.setHeight(rs.getDouble("Height"));
			activer.setWeight(rs.getInt("Weight"));
			activer.setOwnerSSN(rs.getString("OwnerSSN"));
			activer.setHobbies(rs.getString("Hobbies"));
			po.add(activer);
		}
		return po;
	}
	
	public static Profile bestProf(Connection connection) throws SQLException{
		String sql = "Select *" + 
				" From Profile P, User U" + 
				" Where P.OwnerSSN = U.SSN" + 
				" Order By U.Rating DESC" + 
				" Limit 1";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Profile best = new Profile();
		best.setProfileID(rs.getString("ProfileID"));
		best.setAge(rs.getInt("Age"));
		best.setGender(rs.getString("Gender"));
		best.setHeight(rs.getDouble("Height"));
		best.setWeight(rs.getInt("Weight"));
		best.setOwnerSSN(rs.getString("OwnerSSN"));
		best.setHobbies("Hobbies");
		
		return best;
	}
	
	public static ArrayList<locationRate> bestLoc (Connection connection) throws SQLException{
		String sql = "Select D.Location, Count (D.Location) AS 'PopularDateLoc' From Date D Group By D.Location order By PopularDateLoc DESC";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<locationRate> lr = new ArrayList<locationRate>();
		while(rs.next()) {
			locationRate temp = new locationRate();
			temp.setProfileID(rs.getString("ProfileID"));
			temp.setRate(rs.getInt("PopularDateLoc"));
			lr.add(temp);
		}
		return lr;
	}
	
	public static ArrayList<Profile> mySuggestList(Connection connection, String haircolor, double height, int weight)throws SQLException{
		String sql = "Select P.ProfileID From Profile P Where P.HairColor = ? Or P.Height=? Or P.Weight=?";
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
		ps.setString(1, haircolor);
		ps.setDouble(2, height);
		ps.setInt(3, weight);
		ArrayList<Profile> sugList = new ArrayList<Profile>();
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Profile temp = new Profile();
			temp.setHairColor(rs.getString("HairColor"));
			temp.setHeight(rs.getDouble("Height"));
			temp.setWeight(rs.getInt("Weight"));
			sugList.add(temp);
		}
		
		return sugList;		
	}
	

}

