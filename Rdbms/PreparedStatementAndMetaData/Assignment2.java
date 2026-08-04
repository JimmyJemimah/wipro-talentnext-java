package Rdbms.PreparedStatementAndMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment2 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle"; // Update if your password is different

        // Sample input parameters
        int rollno = 1001;
        String name = "JOHN";
        String standard = "IV";
        String dob = "15-Aug-2005";
        double fees = 5000.00;

        // Validations according to assignment criteria
        if (rollno < 1000 || rollno > 9999) {
            System.out.println("Error: Rollno must be a 4-digit number.");
            return;
        }

        if (!name.equals(name.toUpperCase()) || name.length() > 20) {
            System.out.println("Error: StudentName must be up to 20 letters in uppercase.");
            return;
        }

        if (!standard.matches("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$")) {
            System.out.println("Error: Standard must be a Roman numeral from I to X.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create student table if missing
            try {
                stmt.executeUpdate("CREATE TABLE student (rollno NUMBER(4) PRIMARY KEY, studentname VARCHAR2(20) NOT NULL, standard VARCHAR2(2) NOT NULL, date_of_birth DATE, fees NUMBER(9,2))");
            } catch (SQLException ignored) {}

            String sql = "INSERT INTO student VALUES (?, ?, ?, TO_DATE(?, 'DD-Mon-YYYY'), ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, rollno);
                pstmt.setString(2, name);
                pstmt.setString(3, standard);
                pstmt.setString(4, dob);
                pstmt.setDouble(5, fees);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Student record inserted successfully.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}