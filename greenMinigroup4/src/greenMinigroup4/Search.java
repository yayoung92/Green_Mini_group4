package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class Search {

	public void search(String name, int Searchidx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
        try {
        	conn = DBConnection.getConnection();
        	String sql = "SELECT * FROM mini WHERE name LIKE ? and u_idx LIKE ?";
        	pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, Searchidx);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("검색결과");
            
            while(rs.next()) {
            	
            	System.out.println("이름 : " + rs.getString("name"));
            	System.out.println("나이 : " + rs.getString("age"));
            	System.out.println("성별 : " + rs.getString("gender"));
            	System.out.println("전화번호 : " + rs.getString("phoneNumber"));
            	System.out.println("MBTI : " + rs.getString("MBTI"));
            	System.out.println("주소 : " + rs.getString("address"));
            	System.out.println("별명 : " + rs.getString("nickName"));
            	System.out.println("카테고리 : " + rs.getString("category"));
            }
	}catch(Exception e) {
        e.printStackTrace();
    }
}	
}

