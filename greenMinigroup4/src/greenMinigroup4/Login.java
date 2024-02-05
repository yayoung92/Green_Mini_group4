package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;
import infor.User;

public class Login {
	User user = new User();

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

	// 로그인 정보 받는 코드
	public User inputUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("          <      로그인 하기      >          ");
		System.out.print("  ●  아이디를 입력하세요: ");
		String id = scan.next();

		System.out.print("  ●  비밀번호를 입력하세요: ");
		String password = scan.next();

		return new User(id, password);
	}
}
