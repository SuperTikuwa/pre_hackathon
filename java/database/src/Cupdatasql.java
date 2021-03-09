package database.src;

import java.sql.*;

public class Cupdatasql{
    public static void updata(int uid){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            PreparedStatement sql = conn.prepareStatement(
                    "UPDATE tasks_list SET completion = 1" +
                            "    WHERE id = ?;");
            sql.setInt(1, uid);
            int hrs = sql.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}