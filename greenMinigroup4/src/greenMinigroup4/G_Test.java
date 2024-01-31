package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;

public class G_Test {
	public void update(Person person) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
        	conn = DBConnection.getConnection();
        	String sql = "update person " +
                    "(name, age, gender, phoneNumber, MBTI, address, nickName, category) " +
                    "where name = ?";
        	pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            pstmt.setString(3, person.getGender());
            pstmt.setString(4, person.getPhoneNumber());
            pstmt.setString(5, person.getMBTI());
            pstmt.setString(6, person.getAddress());
            pstmt.setString(7, person.getNickName());
            pstmt.setString(8, person.getCategory());
            pstmt.setInt(9, person.getIdx());
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	 public void selectList(int idx) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        List<Person> list = new ArrayList<Person>();

	        try {
	            conn = DBConnection.getConnection();
	            String sql = "select name, age from person where u_idx=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, idx);
	            rs = pstmt.executeQuery();

	            while(rs.next()) {
	                Person person = new Person();
	                person.setName(rs.getString("name"));
	                person.setAge(rs.getInt("age"));
	                person.setPhoneNumber(rs.getString("phoneNumber"));
	                list.add(person);
	            }
	            if(!list.isEmpty()){
	                System.out.println("  ==    동록된 주소록    ==  ");
	                for (Person person : list) {
	                    System.out.println("* 이름 :" + person.getName() + ", 나이 : " + person.getAge() + ", 전화번호 : " + person.getPhoneNumber());
	                }
	            } else
	                System.out.println("  ==    등록된 주소 회원이 없습니다.    ==  ");


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // user 의 id 를 이용해 idx 찾기
	    public int selectIdx(String id){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int idx = 0;
	        try{
	            conn = DBConnection.getConnection();
	            String sql = "select u_idx from user where u_id=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                idx = rs.getInt("u_idx");
	            }

	        }catch (Exception e){
	            e.printStackTrace();;
	        }
	        return idx;
	    }
}
