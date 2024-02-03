package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import db.DBConnection;

public class Update {

	public void update(String oldName, String oldPhone, int u_idx) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET name=?, age=?, gender=?, phoneNumber=?, MBTI=?, address=?, nickName=?, category=? "
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 이름 입력: ");
			pstmt.setString(1, sc.next());
			System.out.print(" 새로운 나이 입력: ");
			pstmt.setInt(2, sc.nextInt());
			System.out.print(" 새로운 성별 입력: ");
			pstmt.setString(3, sc.next());
			System.out.print(" 새로운 전화번호 입력: ");
			pstmt.setString(4, sc.next());
			System.out.print(" 새로운 MBTI 입력: ");
			pstmt.setString(5, sc.next());
			System.out.print(" 새로운 주소 입력: ");
			pstmt.setString(6, sc.next());
			System.out.print(" 새로운 별명 입력: ");
			pstmt.setString(7, sc.next());
			System.out.print(" 새로운 카테고리 입력: ");
			pstmt.setString(8, sc.next());

			pstmt.setString(9, oldName);
			pstmt.setString(10, oldPhone);
			pstmt.setInt(11, u_idx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
