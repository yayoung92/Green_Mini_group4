package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class List {
	
	public int Number(int u_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idxNumber = 0;
		
		try{
			conn = DBConnection.getConnection();
						String sql = "select * from user where u_idx=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, u_idx );
						rs = pstmt.executeQuery();
						
				if(rs.next()){
					idxNumber = rs.getInt("u_idx");
				}
			}catch (Exception e) {
			            e.printStackTrace();
			}
		return idxNumber;
	}
	
	
	public int SearchNumber(String idxNumber ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int index =0;
		String currentCategory = null;
		
		 try {
		        conn = DBConnection.getConnection();
		        String sql = "SELECT name, category, phoneNumber, age FROM person WHERE u_idx = ? ORDER BY category ASC";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, idxNumber);
		        ResultSet rs = pstmt.executeQuery();

		        System.out.println("검색결과");
		        System.out.println();

		        while (rs.next()) {
		            String category = rs.getString("category");
		            if (!category.equals(currentCategory)) {
		                System.out.println("카테고리: " + category);
		                System.out.println();
		                currentCategory = category;
		            }

		            System.out.println("이름 : " + rs.getString("name"));
		            System.out.println("전화번호 : " + rs.getString("phoneNumber"));
		            System.out.println("나이 : " + rs.getString("age"));
		            System.out.println();
		            index++;
		        }

		        if (index == 0) {
		            System.out.println("주소록에 사람이 없습니다");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 

		    return index;
		}
}