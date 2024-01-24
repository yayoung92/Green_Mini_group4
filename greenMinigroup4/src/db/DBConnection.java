package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		String url = "jdbc:mysql://192.168.0.38:3306/ygy";
		String id = "root";
		String pw = "1234";
		
		conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
}
