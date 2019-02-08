package sql;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class SqlConnection {
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	
	public void readDatabase() throws Exception {
		try {
			System.out.println("in connection");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/hsinlin?"
                    + "user=hsinlin&password=110408271&useSSL=false");
			System.out.println("after connection");
		} catch (Exception excep) {
			System.out.println("wrong here");
			throw excep;	
		}	
	}
	
	public Connection getConnected() {
		return connection;
	}

	public void close() {
		try {
			if(resultset != null)
				resultset.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		}catch (Exception excep) {

		}
		 
	}
	
}
