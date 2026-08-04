package Rdbms.PreparedStatementAndMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide rollno as argument: java Assignment3 <rollno>");
            return;
        }

        int rollno = Integer.parseInt(args[0]);
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "oracle";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Ensure StudentLog table exists
            try {
                stmt.executeUpdate("CREATE TABLE StudentLog (rollno NUMBER(4), studentname VARCHAR2(20), standard VARCHAR2(2), leaving_date DATE)");
            } catch (SQLException ignored) {}

            // Retrieve student details before deletion
            String selectSql = "SELECT studentname, standard FROM student WHERE rollno = ?";
            String name = null;
            String standard = null;

            try (PreparedStatement selectPstmt = conn.prepareStatement(selectSql)) {
                selectPstmt.setInt(1, rollno);
                try (ResultSet rs = selectPstmt.executeQuery()) {
                    if (rs.next()) {
                        name = rs.getString("studentname");
                        standard = rs.getString("standard");
                    } else {
                        System.out.println("Student with Roll No " + rollno + " not found.");
                        return;
                    }
                }
            }

            // Insert into StudentLog table
            String logSql = "INSERT INTO StudentLog VALUES (?, ?, ?, SYSDATE)";
            try (PreparedStatement logPstmt = conn.prepareStatement(logSql)) {
                logPstmt.setInt(1, rollno);
                logPstmt.setString(2, name);
                logPstmt.setString(3, standard);
                logPstmt.executeUpdate();
            }

            // Delete record from student table
            String deleteSql = "DELETE FROM student WHERE rollno = ?";
            try (PreparedStatement deletePstmt = conn.prepareStatement(deleteSql)) {
                deletePstmt.setInt(1, rollno);
                deletePstmt.executeUpdate();
                System.out.println("Student record deleted and moved to StudentLog successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}