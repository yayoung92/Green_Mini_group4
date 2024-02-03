package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class Login {
	User user = new User();

	// 로그인 기능
	public int login(String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user where u_id=? and u_password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
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

	// 회원가입 정보 받는 코드
	public User inputUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("          <      로그인 하기      >          ");
		System.out.print("  ●  아이디를 입력하세요: ");
		String id = scan.next();

		System.out.print("  ●  비밀번호를 입력하세요: ");
		String password = scan.next();

		return new User(id, password);

	}

	// 회원가입 기능
	public void join() {
		User user = this.inputUser();
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = checkID(user.getUserId());
		Scanner scan = new Scanner(System.in);

		if (!result) {
			try {
				conn = DBConnection.getConnection();
				String sql = "insert into user (`u_id`,`u_password`) " + "values (?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserPassword());
				pstmt.executeUpdate();

				System.out.println();
				System.out.println("==   성공! 회원가입 되었습니다.   ==");
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println();
			System.err.println("아이디 중복입니다. 회원가입에 실패했습니다.");
			System.out.println();
		}
	}

	// 아이디 중복 확인 기능
	public boolean checkID(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
