package greenMinigroup4; // 업데이트 기능

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection;

public class Update {
	public void update(Person person) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
        	conn = DBConnection.getConnection();
        	String sql = "update mini " +
                    "(name, age, gender, phoneNumber, MBTI, address, nickName, category) " +
                    "where name = ?";
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
