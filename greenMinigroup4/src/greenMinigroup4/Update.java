package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import db.DBConnection;

public class Update {

	public void AllUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET name=?, age=?, gender=?, phoneNumber=?, "
					+ "MBTI=?, address=?, nickName=?, category=? "
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 이름 입력: ");
			pstmt.setString(1, sc.next());
			System.out.print(" 새로운 나이 입력: ");
			pstmt.setString(2, sc.next());
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

	        pstmt.setString(9, OldName);
	        pstmt.setString(10, OldPhone);
			pstmt.setInt(11, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void NameUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET name=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 이름 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AgeUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET age=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 나이 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GenderUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET gender=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 성별 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void PhonenumberUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET phoneNumber=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 전화번호 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MBTIUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET MBTI=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 MBTI 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AddressUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET address=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 주소 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void NicknameUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET nickName=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 별명 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CategoryUpdate(String OldName, String OldPhone, int uIdx) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE person SET category=?"
					+ "WHERE name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);

			System.out.print(" 새로운 카테고리 입력: ");
			pstmt.setString(1, sc.next());
		        pstmt.setString(2, OldName);
		        pstmt.setString(3, OldPhone);
			pstmt.setInt(4, uIdx);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
