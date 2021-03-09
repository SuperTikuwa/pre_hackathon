package database.src;

import java.sql.*;

public class SelectSql {
    public static ResultSet select(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet hrs = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            PreparedStatement sql = conn.prepareStatement(
                    "SELECT tasks_list.id,register_day,detail,deadline,person_name,completion " +
                            "    FROM tasks_list " +
                            "    INNER JOIN person " +
                            "    ON tasks_list.id = person.id;");
            hrs = sql.executeQuery();

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
        return hrs;
    }
}
