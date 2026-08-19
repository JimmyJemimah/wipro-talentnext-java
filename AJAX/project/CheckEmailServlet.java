package com.xyz.library;

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

    private static final String DB_URL = "jdbc:mysql://localhost:3306/xyz_library_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

        if (email == null || email.trim().isEmpty()) {
            out.print("");
            return;
        }

        email = email.trim();

        // 1. Email pattern validation
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            out.print("Invalid email-id");
            return;
        }

        // 2. Database existence check
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "SELECT COUNT(*) FROM XYZ_PROFILE WHERE LOWER(Email) = LOWER(?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, email);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next() && rs.getInt(1) > 0) {
                            out.print("Email already exists!");
                        } else {
                            out.print(""); // Valid and available
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("Server error during validation");
        }
    }
}