package database.src;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SelectSql {
    public static ArrayList<GetData> select(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet hrs = null;
        ArrayList<GetData> rtn = new ArrayList<GetData>();
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/pre_db", "hoge", "hogehoge");
            PreparedStatement sql = conn.prepareStatement(
                    "SELECT register_day,detail,person_name,deadline" +
                            "    FROM tasks_list " +
                            "    INNER JOIN person " +
                            "    ON tasks_list.id = person.id;");
            hrs = sql.executeQuery();
            int i = 0;
            while (hrs.next()) {
                GetData ind = new GetData(
                        new SimpleDateFormat("yyyy-MM-dd")
                        .format(hrs.getDate("register_day")),
                                hrs.getString("detail"),
                                hrs.getString("person_name"),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .format(hrs.getDate("deadline")));
                rtn.add(ind);
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
        return rtn;
    }
}
