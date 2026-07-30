import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleTest {
    public static void main(String[] args) {
        // Direct thin connection string to bypass network name resolution
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
        String user = "hr";
        String password = "hr";

        try {
            // Load the Oracle JDBC Driver that you have in your folder (ojdbc8.jar)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("SUCCESS! Connected cleanly.");

            // Assignment 2 & 3 Query Simulation
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT employee_id, first_name, salary FROM employees WHERE ROWNUM <= 5");
            
            System.out.println("\n--- EMPLOYEE DATA ---");
            while (rs.next()) {
                System.out.println(rs.getInt("employee_id") + " | " + rs.getString("first_name") + " | $" + rs.getDouble("salary"));
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println("\nConnection Failed! Error Detail:");
            e.printStackTrace();
        }
    }
}