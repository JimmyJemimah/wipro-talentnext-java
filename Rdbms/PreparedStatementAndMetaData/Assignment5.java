package Rdbms.PreparedStatementAndMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assignment5 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle";

        boolean hasRollNo = args.length > 0;
        String sql = hasRollNo ? "SELECT * FROM student WHERE rollno = ?" : "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (hasRollNo) {
                pstmt.setInt(1, Integer.parseInt(args[0]));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("ROLLNO\tNAME\tSTD\tDOB\t\tFEES");
                System.out.println("--------------------------------------------------");

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println(rs.getInt("rollno") + "\t" +
                                       rs.getString("studentname") + "\t" +
                                       rs.getString("standard") + "\t" +
                                       (rs.getDate("date_of_birth") != null ? rs.getDate("date_of_birth") : "N/A") + "\t" +
                                       rs.getDouble("fees"));
                }

                if (!found && hasRollNo) {
                    System.out.println("No student found with rollno: " + args[0]);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}