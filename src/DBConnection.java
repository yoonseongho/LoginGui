import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {
        /* 데이터베이스 접속 객체 */
        Connection conn = null;
        try {
            /* MySql 드라이버 로드 */
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* 데이터베이스 접속 */
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Login?serverTimezone=Asia/Seoul",
                    "fourjo",
                    "1234");
            Access access = new Access();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e2) {
            e2.getMessage();
        } finally {
            if (conn != null) {
                System.out.println("데이터베이스 접속");
            }
        }
    }
}