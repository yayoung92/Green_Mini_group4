package greenMinigroup4; // 업데이트 기능

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection; // Assuming you have a DBConnection class for database connectivity

public class Update {

    private static final String UPDATE_QUERY = "UPDATE mini SET name=?, gender=?, age=?, MBTI=?, address=?, nickname=?, category=? WHERE name=?";
    private static final String SELECT_QUERY = "SELECT * FROM mini WHERE name=?";

    private static void updateData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------데이터 갱신----------");
        System.out.print("갱신할 데이터의 이름을 입력하세요: ");
        String targetName = scanner.next();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(SELECT_QUERY);
             PreparedStatement updateStmt = conn.prepareStatement(UPDATE_QUERY)) {

            selectStmt.setString(1, targetName);
            ResultSet resultSet = selectStmt.executeQuery();

            boolean found = false;

            while (resultSet.next()) {
                System.out.println("현재 데이터:");
                System.out.println("이름: " + resultSet.getString("name"));
                System.out.println("성별: " + resultSet.getString("gender"));
                System.out.println("나이: " + resultSet.getInt("age"));
                // Add more fields as needed

                found = true;

                System.out.println("새로운 데이터를 입력하세요:");

                System.out.print("이름: ");
                updateStmt.setString(1, scanner.next());

                System.out.print("성별: ");
                updateStmt.setString(2, scanner.next());

                System.out.print("나이: ");
                updateStmt.setInt(3, scanner.nextInt());

                System.out.print("MBTI: ");
                updateStmt.setString(4, scanner.next());

                System.out.print("주소: ");
                updateStmt.setString(5, scanner.next());

                System.out.print("닉네임: ");
                updateStmt.setString(6, scanner.next());

                System.out.print("카테고리: ");
                updateStmt.setString(7, scanner.next());

                updateStmt.setString(8, targetName); // Set the original name for WHERE clause

                updateStmt.executeUpdate();

                System.out.println("데이터 갱신이 완료되었습니다.");
            }

            if (!found) {
                System.out.println("일치하는 데이터가 없습니다.");
            }

        } catch (SQLException e) {
            System.out.println("데이터를 갱신하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
