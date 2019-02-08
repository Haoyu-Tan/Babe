package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javabeans.Referral;

public class ReferralData {
	public static void insertReferral(Connection connection, Referral refer) throws SQLException{
		String sql = "insert into hsinlin.Likes(ProfileA, ProfileB, ProfileC, Date_Time)" 
						+ "values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date referD = refer.getDateTime();
		
		ps.setString(1, refer.getProfileA());
		ps.setString(2, refer.getProfileB());
		ps.setString(2, refer.getProfileC());
		ps.setString(4, dateFormat.format(referD));
		ps.executeUpdate();
	}

}
