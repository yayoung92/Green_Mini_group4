package greenMinigroup4; // 업데이트 기능

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection; // 실제 DB 연결 클래스로 대체해야 합니다.

public class Update {

    private static final String UPDATE_QUERY = "UPDATE mini SET name=?, gender=?, age=?, MBTI=?, address=?, nickname=?, category=? WHERE name=?";
    private static final String SELECT_QUERY = "SELECT * FROM mini WHERE name=?";

    private static void updateData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------데이터 갱신----------");
        System.out.print("갱신할 데이터의 이름을 입력하세요: ");
        String targetName = scanner.next();

        try {
            Class.forName("your_database_driver_class_name"); // 실제 사용하는 데이터베이스 드라이버 클래스로 대체

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
                    // 필요한 만큼의 필드를 추가하세요.

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

                    updateStmt.setString(8, targetName); // WHERE 절에 사용할 원래 이름 설정

                    updateStmt.executeUpdate();

                    System.out.println("데이터 갱신이 완료되었습니다.");
                }

                if (!found) {
                    System.out.println("일치하는 데이터가 없습니다.");
                }

            } catch (SQLException e) {
                System.out.println("SQL 예외 발생: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없음: " + e.getMessage());
        }
    }
}
