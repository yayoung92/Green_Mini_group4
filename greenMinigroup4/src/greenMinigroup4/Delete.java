package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;

public class Delete { 
	// 회워탈퇴
	public int delete(String name, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from user where u_id=? and u_passphoneNumber word=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(result==1) {
			return 1;			
		} else
			return 0;
	}
	
	public int deleteperson(String name, String phonenumber, int deleteidx ) {
		// 주소록 삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from mini where name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phonenumber);
			pstmt.setInt(3, deleteidx);
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(result==1) {
			return 1;			
		} else
			return 0;
		
	}
}