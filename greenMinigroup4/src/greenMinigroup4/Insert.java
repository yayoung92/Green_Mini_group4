package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection;
import infor.Person;

public class Insert { // u_idx 값을 가져오는것

	// 아이디 기준으로 u_idx 값을 가져온다.
	public int idx(String idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uidx = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "select * from user where u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				uidx = rs.getInt("u_idx");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uidx;
	}

	public boolean Find(String PNumber, int u_idx) { // 휴대폰 번호는 중복으로 안되게 한다

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM person WHERE phoneNumber = ? and u_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PNumber);
			pstmt.setInt(2, u_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void insert(Person person, int InsertIdx) { // 등록하는 부분
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);

		Person p = new Person();
		System.out.print(" -  이름 : ");
		p.setName(scanner.next());
		System.out.print(" -  나이 : ");
		p.setAge(scanner.nextInt());
		System.out.print(" -  성별 : ");
		p.setGender(scanner.next());
		System.out.print(" -  전화번호 : ");
		p.setPhoneNumber(scanner.next());
		System.out.print(" -  MBTI : ");
		p.setMBTI(scanner.next());
		System.out.print(" -  주소 : ");
		p.setAddress(scanner.next());
		System.out.print(" -  별명 : ");
		p.setNickName(scanner.next());
		System.out.print(" -  카테고리 : ");
		p.setCategory(scanner.next());

		boolean result = Find(p.getPhoneNumber(), InsertIdx);

		if (result == false) {
			try {
				conn = DBConnection.getConnection();
				String sql = "insert into person "
						+ "(name, age, gender, phoneNumber, MBTI, address, nickName, category, u_idx) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, p.getName());
				pstmt.setInt(2, p.getAge());
				pstmt.setString(3, p.getGender());
				pstmt.setString(4, p.getPhoneNumber());
				pstmt.setString(5, p.getMBTI());
				pstmt.setString(6, p.getAddress());
				pstmt.setString(7, p.getNickName());
				pstmt.setString(8, p.getCategory());
				pstmt.setInt(9, InsertIdx);
				pstmt.executeUpdate();
				System.out.println();
				System.out.println(" [ 등록되었습니다 ] ");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println();
			System.err.println("[ 중복된 전화번호입니다 ]");
		}
	}

}
