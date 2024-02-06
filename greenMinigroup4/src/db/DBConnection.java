package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		String url = "jdbc:mysql://127.0.0.1/jjj";	
		String id = "root";
		String pw = "1234";
		
		conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
}
