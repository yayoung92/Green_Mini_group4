package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBConnection;

public class Delete {
	// 주소록 사람 삭제하거나 카테고리 삭제하는 전체코드
	public void deleteChoice(String id) {
		Scanner scan = new Scanner(System.in);
		Delete delete = new Delete();

		System.out.println("1.주소록 등록인 삭제  2.카테고리 삭제 ");
		System.out.print(" >>  번호 선택  :  ");
		int num = scan.nextInt();

		if (num == 1) {
			delete.deletePerson(delete.selectIdx(id));
		} else if (num == 2) {
			delete.deleteCategory(delete.selectIdx(id));
		}
	}

	// 유저의 idx 가져오기
	public int selectIdx(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idx = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "select u_idx from user where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				idx = rs.getInt("u_idx");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idx;
	}

	// 유저의 주소록 사람 삭제하기
	public void deletePerson(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		Scanner scan = new Scanner(System.in);

		try {
			conn = DBConnection.getConnection();
			String sql = "delete from person where name=? and phoneNumber=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);
			System.out.println();
			System.out.print("> 삭제할 사람의 이름을 입력해주세요 : ");
			pstmt.setString(1, scan.next());
			System.out.print("> 삭제할 사람의 번호를 입력해주세요 : ");
			pstmt.setString(2, scan.next());
			pstmt.setInt(3, idx);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println(" [ 주소록 사람이 삭제되었습니다. ] ");

		} else if (result == 0)
			System.err.println(" [ 주소록에 없는 사람입니다. ] ");
	}

	// 카테고리 삭제하기
	public void deleteCategory(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		Scanner scan = new Scanner(System.in);

		try {
			conn = DBConnection.getConnection();
			String sql = "update person set category=? where category=? and u_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "미등록");
			System.out.println();
			System.out.print("> 삭제할 카테고리를 입력해주세요 : ");
			pstmt.setString(2, scan.next());
			pstmt.setInt(3, idx);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			System.out.println(" [ 카테고리가 삭제되었습니다. ] ");

		} else if (result == 0)
			System.err.println(" [ 없는 카테고리 입니다. ] ");

	}
}