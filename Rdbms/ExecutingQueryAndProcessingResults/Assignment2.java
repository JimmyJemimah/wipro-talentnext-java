package Rdbms.ExecutingQueryAndProcessingResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment2 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle"; // Replace with your actual password

        String query = "SELECT ename, job, sal, comm FROM emp WHERE sal > 1000 AND sal < 2000";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ENAME\tJOB\t\tSAL\tCOMM");
            System.out.println("----------------------------------------");

            while (rs.next()) {
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");

                System.out.println(ename + "\t" + job + "\t" + sal + "\t" + comm);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}