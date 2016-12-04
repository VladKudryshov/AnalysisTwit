package DataBase;
import FileProcessing.ScanFIle;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

/**
 * Created by programming on 23.2.16.
 */
public class ConnectDB {

    private String host;
    private String user;
    private String password;
    private String database;
    private String url;

    private Connection conn;
    private Properties properties = new Properties();


    public ConnectDB(String host, String user, String password, String database) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    private void initProperties(){
        url = "jdbc:mysql://" +host+"/" +database;
        properties.setProperty("user",user);
        properties.setProperty("password",password);
        properties.setProperty("characterEncoding","UTF-8");
        properties.setProperty("useUnocode","true");
    }


    public void Connect(){
        try {
            initProperties();
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url,properties);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        InsertTable query = new InsertTable(conn);
        query.SetDataTable();
    }
}
