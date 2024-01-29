package greenMinigroup4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;

public class Insert {
	User user = new User();
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
    
	public void insert(Person person) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
        try {
        	conn = DBConnection.getConnection();
        	String sql = "insert into mini " +
                    "(name, age, gender, phoneNumber, MBTI, address, nickName, category, u_idx) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getAge());
            pstmt.setString(3, person.getGender());
            pstmt.setString(4, person.getPhoneNumber());
            pstmt.setString(5, person.getMBTI());
            pstmt.setString(6, person.getAddress());
            pstmt.setString(7, person.getNickName());
            pstmt.setString(8, person.getCategory());
            pstmt.setInt(9, person.getU_idx());
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
