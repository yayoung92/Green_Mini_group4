package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class CategorySearch {

	public void categorysearch(String category, int categoryidx) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM mini WHERE category LIKE ? and u_idx LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setInt(2, categoryidx);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println();
				System.out.print("이름 : " + rs.getString("name") + "\t");
				if(rs.getString("age").length()==1)
					System.out.print("●나이 : " + rs.getString("age") + "\t\t");
				else
					System.out.print("●나이 : " + rs.getString("age") + "\t");
				System.out.print("●전화번호 : " + rs.getString("phoneNumber") + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
