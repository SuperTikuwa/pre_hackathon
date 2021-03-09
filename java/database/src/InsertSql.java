package database.src;

import java.sql.*;
import java.util.Date;

public class InsertSql {
    public static void insert(Date rgstr, String dtl, int prsnid, Date ddln){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            PreparedStatement sql = conn.prepareStatement(
                    "INSERT INTO " +
                    "    tasks_lest(register_day,detail,person_id,deadline) " +
                    "VALUES " +
                    "    (?,?,?,?);");
            sql.setDate(1, (java.sql.Date) rgstr);
            sql.setString(2,dtl);
            sql.setInt(3,prsnid);
            sql.setDate(4, (java.sql.Date) ddln);
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
