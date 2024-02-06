package greenMinigroup4;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import db.DBConnection;

public class Search {

	public void searchDetail(String name, int u_idx) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnection.getConnection();

			pstmt = con.prepareStatement("SELECT distinct * FROM person " + "WHERE u_idx=? and NAME=? ");

			pstmt.setInt(1, u_idx);
			pstmt.setString(2, name);
			ResultSet result = pstmt.executeQuery();

			int a=0;


			while (result.next()) {
				System.out.println("이름  :  " + result.getString("name"));
				System.out.println("나이  :  " + result.getString("age"));
				System.out.println("성별  :  " + result.getString("gender"));
				System.out.println("번호  :  " + result.getString("phoneNumber"));
				System.out.println("엠비티아이  :  " + result.getString("MBTI"));
				System.out.println("주소  :  " + result.getString("address"));
				System.out.println("별명  :  " + result.getString("nickName"));
				System.out.println("소속  :  " + result.getString("category"));
				System.out.println();
				a++;
			}
			
			if(a==0) {
				System.out.println("조회된 정보가 없습니다.");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
