package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class Insert {
	public void insert(Person person) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
        try {
        	conn = DBConnection.getConnection();
        	String sql = "insert into mini " +
                    "(name, age, gender, phoneNumber, MBTI, address, nickName, category, u_idx) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, "
                    + "select u.u_idx "
                    + "from user u "
                    + "where u.u_idx = ?)";
        	pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getAge());
            pstmt.setString(3, person.getGender());
            pstmt.setString(4, person.getPhoneNumber());
            pstmt.setString(5, person.getMBTI());
            pstmt.setString(6, person.getAddress());
            pstmt.setString(7, person.getNickName());
            pstmt.setString(8, person.getCategory());
            pstmt.setInt(9, person.getIdx());
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
