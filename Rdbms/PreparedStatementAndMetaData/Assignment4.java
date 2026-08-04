package Rdbms.PreparedStatementAndMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Assignment4 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Assignment4 <rollno> <new_fee>");
            return;
        }

        int rollno = Integer.parseInt(args[0]);
        double newFee = Double.parseDouble(args[1]);

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle";

        String sql = "UPDATE student SET fees = ? WHERE rollno = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newFee);
            pstmt.setInt(2, rollno);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Fee updated successfully for rollno: " + rollno);
            } else {
                System.out.println("Student with rollno " + rollno + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}