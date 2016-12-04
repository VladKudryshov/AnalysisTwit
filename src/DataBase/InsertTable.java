package DataBase;

import FileProcessing.ScanFIle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExportControlled;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by programming on 23.2.16.
 */
public class InsertTable {

    private Connection conn;
    private Statement statement = null;


    public InsertTable(Connection conn) {
        this.conn = conn;
    }

    private ScanFIle file = new ScanFIle("all_tweetss.txt");
    private CreateSQL SQL_Query = new CreateSQL();

    public void SetDataTable() {
        String Query = "";
        int i = 0;
        try {
            statement = (Statement) conn.createStatement();
            ArrayList<String> ArrayDataQuery = file.GetAllString();
            for (String str : ArrayDataQuery) {
                try {
                    Query = SQL_Query.createSQLQuery(str);
                    statement.executeUpdate(Query);
                } catch (Exception e) {
                    System.out.println(i + str);
                    try {
                        System.out.println(true);
                        String sql = "UPDATE temp SET message = CONCAT(message, ' ' , '"+str+"') WHERE id = '(SELECT MAX(id) from temp)'";
                        statement.executeUpdate(sql);
                    } catch (Exception q) {
                        System.out.println(q);
                    }
                }
            i++;
            }
        }catch (SQLException e)
            {
                e.printStackTrace();
            }
        finally {
            try {
                conn.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
