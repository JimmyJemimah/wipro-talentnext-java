package Rdbms.ExecutingQueryAndProcessingResults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment1 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle"; // Change to your actual password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Ensure 'emp' table exists
            createEmpTableIfMissing(stmt);

            String query = "SELECT empno, ename FROM emp";
            try (ResultSet rs = stmt.executeQuery(query)) {

                System.out.println("EMPNO\tENAME");
                System.out.println("-----------------");

                while (rs.next()) {
                    // empno retrieved using column index (1)
                    int empno = rs.getInt(1); 
                    // ename retrieved using column name ("ename")
                    String ename = rs.getString("ename"); 

                    System.out.println(empno + "\t" + ename);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void createEmpTableIfMissing(Statement stmt) {
        try {
            stmt.executeUpdate("CREATE TABLE emp (empno NUMBER(4), ename VARCHAR2(10), job VARCHAR2(9), sal NUMBER(7,2), comm NUMBER(7,2))");
            stmt.executeUpdate("INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 800, NULL)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 1600, 300)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 1250, 500)");
            stmt.executeUpdate("INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 2975, NULL)");
        } catch (SQLException ignored) {
            // Table already exists, proceed to query
        }
    }
}