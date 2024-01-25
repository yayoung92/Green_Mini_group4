package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				

			}else {
				System.out.println("회원정보가 없습니다.");
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	// 회원가입 기능
	public void join(String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = checkID(name);

		if (!result) {
			try {
				conn = DBConnection.getConnection();
				String sql = "insert into user (`u_id`,`u_password`) " + "values (?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
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
//		finally{
//			if(conn != null) {
//				try{
//					conn.close();
//				} catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
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
	
	// 비밀번호 찾아서 비교해야하나? 비밀번호 틀리면 비밀번호 틀렸다고 알려주고 싶은뎅


}
