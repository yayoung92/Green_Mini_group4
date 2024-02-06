package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import controller.Main;
import db.DBConnection;

public class Signout {
	
	// 유저의 회원탈퇴
	public int delete(String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "delete from user where u_id=? and u_password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			return 1;
		} else
			return 0;
	}
	// 유저 회원탈퇴 시 유저의 주소록 삭제하기
	public void deleteIdxPerson(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "delete from person where u_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
