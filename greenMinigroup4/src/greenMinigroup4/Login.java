package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;
import infor.User;

public class Login {
	// 로그인 기능
	public int login(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user where u_id=? and u_password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {

			} else {
				ConsoleTextColor.printColorln("회원정보가 없습니다.", "green");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
