import database.src.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class databaseTest{
    public static void main(String[] args) throws ParseException, SQLException {
        int i = 3;
        switch (i){
            case 0:
                java.sql.Date rg = java.sql.Date.valueOf("2020-01-01");
                java.sql.Date dl = java.sql.Date.valueOf("2020-01-01");
                InsertSql.insert("はやおき",3,dl);
                break;
            case 1:
                DeleteSql.delete(1);
                break;
            case 2:
                Cupdatasql.updata(1);
                break;
            case 3:
                ArrayList<GetData> p = SelectSql.select();
                for (GetData p1 : p){
                    System.out.println(p1.getdetail());
                }
                break;
        }
    }
}
