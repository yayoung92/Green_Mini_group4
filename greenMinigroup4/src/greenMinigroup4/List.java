package greenMinigroup4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class List {
	
	public void listall(int u_idx) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet result = null;
		try {
			con = DBConnection.getConnection();
			pstmt=con.prepareStatement("SELECT * FROM person where u_idx=?");
			pstmt.setInt(1, u_idx);
			
		result=pstmt.executeQuery();
		System.out.println(" 이름 |  나이  |  성별  |       번호       | MBTI |  주소  |  별명  |  소속 ");
		while(result.next()) {
			System.out.println(result.getString("name") + "\t" + result.getString("age")+"\t"+result.getString("gender")+
					"\t"+result.getString("phoneNumber")+"\t"+result.getString("MBTI")+"\t"+result.getString("address")
					+"\t"+result.getString("nickName")+"\t"+result.getString("category"));
			System.out.println();
			
		
		}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
		
}