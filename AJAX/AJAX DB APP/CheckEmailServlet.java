package com.wipro.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckEmailServlet")
public class CheckEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Adjust database connection parameters to match your local database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");

        if (email == null || email.trim().isEmpty()) {
            out.print("Invalid Email Id");
            return;
        }

        email = email.trim();

        // Server-side regex pattern check
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(emailRegex)) {
            out.print("Invalid Email Id");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_PASSWORD, DB_PASSWORD)) {
                // LOWER() ensures case-insensitive database check
                String sql = "SELECT COUNT(*) FROM Profile WHERE LOWER(EMAIL) = LOWER(?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, email);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next() && rs.getInt(1) > 0) {
                            out.print("Not Available!");
                        } else {
                            out.print("Available!");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("Server Error");
        }
    }
}