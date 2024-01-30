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
				System.out.println("검색결과");
				System.out.println();
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("전화번호 : " + rs.getString("phoneNumber"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
