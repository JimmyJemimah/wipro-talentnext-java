package Rdbms.PreparedStatementAndMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOClass {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "system";
    private String password = "oracle"; // Replace with your actual password

    private Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        createTableIfNotExist(conn);
        return conn;
    }

    private void createTableIfNotExist(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE student (rollno NUMBER(5) PRIMARY KEY, name VARCHAR2(20), standard VARCHAR2(5), dob DATE, fees NUMBER(7,2))");
        } catch (SQLException ignored) {
            // Table already exists
        }
    }

    // Option 1: Insert
    public void insert(int rollno, String name, String standard, String dob, double fees) {
        String sql = "INSERT INTO student VALUES (?, ?, ?, TO_DATE(?, 'DD-Mon-YYYY'), ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollno);
            pstmt.setString(2, name);
            pstmt.setString(3, standard);
            pstmt.setString(4, dob);
            pstmt.setDouble(5, fees);

            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Record inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    // Option 2: Delete
    public void delete(int rollno) {
        String sql = "DELETE FROM student WHERE rollno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollno);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Student with Roll No " + rollno + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }

    // Option 3: Modify Fee
    public void modify(int rollno, double fee) {
        String sql = "UPDATE student SET fees = ? WHERE rollno = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, fee);
            pstmt.setInt(2, rollno);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Fee updated successfully.");
            } else {
                System.out.println("Student with Roll No " + rollno + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Modify Error: " + e.getMessage());
        }
    }

    // Option 4: Display (One record or All)
    public void display(String[] args) {
        if (args.length == 2) {
            // Display single record
            int rollno = Integer.parseInt(args[1]);
            String sql = "SELECT * FROM student WHERE rollno = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, rollno);
                try (ResultSet rs = pstmt.executeQuery()) {
                    printResultSet(rs);
                }

            } catch (SQLException e) {
                System.out.println("Display Error: " + e.getMessage());
            }
        } else {
            // Display all records
            String sql = "SELECT * FROM student";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                printResultSet(rs);

            } catch (SQLException e) {
                System.out.println("Display Error: " + e.getMessage());
            }
        }
    }

    private void printResultSet(ResultSet rs) throws SQLException {
        System.out.println("ROLLNO\tNAME\tSTD\tDOB\t\tFEES");
        System.out.println("--------------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("rollno") + "\t" +
                               rs.getString("name") + "\t" +
                               rs.getString("standard") + "\t" +
                               rs.getString("dob").split(" ")[0] + "\t" +
                               rs.getDouble("fees"));
        }
    }
}