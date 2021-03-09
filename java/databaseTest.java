import database.src.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class databaseTest{
    public static void main(String[] args) throws ParseException, SQLException {
        int i = 3;
        switch (i){
            case 0:
                java.sql.Date rg = java.sql.Date.valueOf("2020-01-01");
                java.sql.Date dl = java.sql.Date.valueOf("2020-01-01");
                InsertSql.insert(rg,"はやおき",3,dl);
                break;
            case 1:
                DeleteSql.delete(1);
                break;
            case 2:
                Cupdatasql.updata(1);
                break;
            case 3:
                ResultSet p = SelectSql.select();
                while (p.next()){
                    int id = p.getInt("id");
                    java.sql.Date register_day = java.sql.Date.valueOf(String.valueOf(p.getDate("register_day")));
                    String detial = p.getString("detail");
                    java.sql.Date deadline = java.sql.Date.valueOf(String.valueOf(p.getString("deadline")));
                    String person_name = p.getString("person_name");
                    int completion = p.getInt("completion");
                    System.out.println(id + " " + register_day + " " + detial+ " " + deadline + " " + person_name + " " + completion);
                }
                break;
        }
    }
}
