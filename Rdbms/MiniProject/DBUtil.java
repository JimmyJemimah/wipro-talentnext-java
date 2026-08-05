package MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // Replace details below with your local Oracle connection parameters
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static final String USER = "system";
    private static final String PASSWORD = "oracle"; 

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}