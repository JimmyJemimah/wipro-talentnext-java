package Rdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system"; 
        String password = "oracle"; 

        try {
            // Excluded registration process as per Assignment 2:
            // Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Established successfully");

            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection could not be established ");
            System.out.println(e.getMessage());
        }
    }
}