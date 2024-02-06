package greenMinigroup4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class List {

	public void listall(int u_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String categoryWrite = null;

		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM person where u_idx=? order by category");
			pstmt.setInt(1, u_idx);
			result = pstmt.executeQuery();

			while (result.next()) {
				String category = result.getString("category");

				if (!category.equals(categoryWrite)) {
					System.out.println();
					System.out.println("  == " + category + " == ");
					System.out.println("----------------------------------------------------------------------");
					System.out.println(" 이름  |  나이  |  성별  |       번호       | MBTI |   주소   |  별명  |  소속 ");
					System.out.println("----------------------------------------------------------------------");

					categoryWrite = category;

				}

				System.out.println(result.getString("name") + "\t" + result.getString("age") + "\t"
						+ result.getString("gender") + "\t" + result.getString("phoneNumber") + "\t"
						+ result.getString("MBTI") + "\t" + result.getString("address") + "\t"
						+ result.getString("nickName") + "\t" + result.getString("category") + "\t");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
