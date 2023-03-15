import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Access {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt;

    /* 데이터베이스 접속 */
    public Access() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnection(
                    "",
                    "",
                    ""
            );
        } catch (ClassNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    /* User 입력 */
    public int insertUser(User ur) {
        int result = 0;
        try {
            String sql = "insert into Login(user_id, password, name)" + "values('"
                        + ur.getUserId() + "', '" + ur.getPassword() + "', '" + ur.getName() + "')";
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            if (result > 0) {
                System.out.println("처리 완료");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /* User 조회 */
    public User select(String userID) {

        User ur = new User();
        try {
            String sql = "select * from Login where user_id = '" + userID + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                ur.setPassword(rs.getString("password"));
                ur.setUserId(rs.getString("user_id"));
                ur.setName(rs.getString("name"));

                return ur;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /* 로그인 */
    public int login(String userID, String userPassword) { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을 판단함.
        String SQL = "SELECT password FROM login WHERE user_id = ?"; // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
            if (rs.next()) {
                if (rs.getString(1).contentEquals(userPassword)) {
                    return 1; // 로그인 성공
                } else {
                    return 0; // 비밀번호 불일치
                }
            }

            return -1; // 아이디가 없음
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -2; // DB 오류
    }

    /* User 수정 */
    public int update(User ur) {
        int result = 0;
        try {
            String sql = "update Login set password='" + ur.getPassword() + "', name='"
                    + ur.getName() + "'" + "where user_id='" + ur.getUserId() + "'";
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        return result;
    }

    /* User 삭제 */
    public int delete(String userID) {
        int result = 0;
        try {
            String sql = "delete from Login where user_id = '" + userID + "'";
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
        return result;
    }

    public int passwordUpdate(String userID, String password) {
        int result = 0;
        try {
            String sql = "update Login set password='" + password + "'" + "where user_id='" + userID + "'";

            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /* 자원 close() */
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
}