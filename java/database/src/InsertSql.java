package database.src;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSql {
    public static void insert(java.sql.Date rgstr, String dtl, int prsnid, java.sql.Date ddln){
        Connection conn = null;
        Statement stmt = null;
        try{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            PreparedStatement sql = conn.prepareStatement(
                    "INSERT INTO " +
                    "    tasks_list(register_day,detail,person_id,deadline) " +
                    "VALUES " +
                    "    (?,?,?,?);");
            sql.setDate(1, rgstr);
            sql.setString(2,dtl);
            sql.setInt(3,prsnid);
            sql.setDate(4, ddln);
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
