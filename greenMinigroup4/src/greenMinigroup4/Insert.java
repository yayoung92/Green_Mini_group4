package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection;

public class Insert {

	// 아이디 기준으로 u_idx 값을 가져온다.
	public int idx(String idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uidx = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				uidx = rs.getInt("u_idx");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uidx;
	}

	public void insert(Person person, int InsertIdx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = Find(person.getPhoneNumber());

		if (!result) {
			try {
				conn = DBConnection.getConnection();
				String sql = "insert into mini "
						+ "(name, age, gender, phoneNumber, MBTI, address, nickName, category, u_idx) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				Scanner scanner = new Scanner(System.in);

				System.out.print(" -  이름 : ");
				pstmt.setString(1, scanner.next());
				System.out.print(" -  나이 : ");
				pstmt.setString(2, scanner.next());
				System.out.print(" -  성별 : ");
				pstmt.setString(3, scanner.next());
				System.out.print(" -  전화번호 : ");
				pstmt.setString(4, scanner.next());
				System.out.print(" -  MBTI : ");
				pstmt.setString(5, scanner.next());
				System.out.print(" -  주소 : ");
				pstmt.setString(6, scanner.next());
				System.out.print(" -  별명 : ");
				pstmt.setString(7, scanner.next());
				System.out.print(" -  카테고리 : ");
				pstmt.setString(8, scanner.next());
				pstmt.setInt(9,InsertIdx);
				pstmt.executeUpdate();
				
				System.out.println(" [ 등록되었습니다. ] ");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("중복이다 머글아");
		}
	}

	public boolean Find(String PNumber) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM mini WHERE phoneNumber LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PNumber);
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
