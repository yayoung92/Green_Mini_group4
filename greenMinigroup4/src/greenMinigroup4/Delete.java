package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class Delete {
	// 유저의 회원탈퇴
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

	// 유저의 idx 가져오기
    public int selectIdx(String id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int idx = 0;
        try{
            conn = DBConnection.getConnection();
            String sql = "select u_idx from user where u_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                idx = rs.getInt("u_idx");
            }

        }catch (Exception e){
            e.printStackTrace();;
        }
        return idx;
    }
    // 유저 회원탈퇴 시 유저의 주소록 삭제하기
    public void deleteIdxPerson(int idx) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "delete from mini where u_idx=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idx);
            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // 유저의 주소록 사람 1명 삭제하기 - 진행중
	public int deleteperson(String name, String phoneNumber, int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from mini where name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setInt(3, idx);

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