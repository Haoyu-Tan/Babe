package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javabeans.Profile;
import javabeans.User;

public class LoginUpdate {

	public static void updateModDate(Connection connection, Profile P)throws SQLException {
		Calendar cald = Calendar.getInstance();
		P.setLastModDate(cald);
		
		//TRANSFORM AND UPDATE TO DATABASE
		String sql = "Update hsinlin.Profile P Set P.LastModDate = ? Where OwnerSSN = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateOfAct = P.getLastModDate().getTime();
        pstm.setString(1, dateFormat.format(dateOfAct));
		pstm.setString(2, P.getOwnerSSN());
		pstm.executeUpdate();
	}
	
	public static void updateRating (Connection connection, User u, int rating) throws SQLException{
		int before = u.getRating();
		int result = (before + rating)/2;
		u.setRating(result);
		
		String sql = "Update hsinlin.User U Set U.Rating = ? Where U.SSN = ?";
		PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql);
		pstm.setInt(1, rating);
		pstm.setString(2, u.getSSN());
		//UPDATE TO DATABASE
		pstm.executeUpdate();
	}

}
