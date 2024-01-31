package greenMinigroup4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import db.DBConnection;


public class Search {
/*
	public void search(String name) {
	
			Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
			
			pstmt
            = con.prepareStatement("SELECT*FROM member\r\n"
            		+ "WHERE NAME=?");
			
			pstmt.setString(1,name); // ?에 들어갈 데이터
			ResultSet result=pstmt.executeQuery();
			System.out.println(result.getString("name"));
			System.out.println(result.getString("email"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	*/
	public void searchDetail(String name,int u_idx) {
		
		
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.getConnection();

            pstmt = con.prepareStatement("SELECT * FROM person "
            		+ "WHERE NAME=? ");
			
			pstmt.setString(2,name);
			pstmt.setInt(1,u_idx);
			ResultSet result=pstmt.executeQuery();
			while(result.next()) {
				System.out.println("이름  :  "+result.getString("name"));
				System.out.println("나이  :  "+result.getString("age"));
				System.out.println("성별  :  "+result.getString("gender"));
				System.out.println("번호  :  "+result.getString("phoneNumber"));
				System.out.println("엠비티아이  :  "+result.getString("MBTI"));
				System.out.println("주소  :  "+result.getString("address"));
				System.out.println("별명  :  "+result.getString("nickName"));
				System.out.println("소속  :  "+result.getString("category"));
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
