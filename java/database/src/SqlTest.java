package database.src;

import java.sql.*;

public class SqlTest {
    public static void main(String args[]){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                   "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            String dt = "SELECT * FROM person";

            PreparedStatement sql = conn.prepareStatement(dt);
            ResultSet hrs = sql.executeQuery();

            while (hrs.next()){
                int id = hrs.getInt("id");
                String person_name = hrs.getString("person_name");
                System.out.println(id + " " + person_name);
            }

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
