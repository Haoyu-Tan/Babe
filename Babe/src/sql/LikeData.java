package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javabeans.Likes;

public class LikeData {
	
	public void insertLikes(Connection connection, Likes like) throws SQLException{
		String sql = "insert into hsinlin.Likes(Liker, Likee, Date_Time)" 
						+ "values(?,?,?)";
		PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date likeD = like.getDateTime();

        System.out.println(dateFormat.format(likeD));
		
		ps.setString(1, like.getLiker());
		ps.setString(2, like.getLikee());
		ps.setString(3, dateFormat.format(likeD));
		ps.executeUpdate();
	}

}
