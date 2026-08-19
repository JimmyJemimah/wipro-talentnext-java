package com.xyz.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/xyz_library_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String occupation = request.getParameter("occupation");
        String city = request.getParameter("city");
        String mobile = request.getParameter("mobile");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "INSERT INTO XYZ_PROFILE (Email, Password, Name, DateOfBirth, Gender, Occupation, City, Mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, email);
                    pstmt.setString(2, password);
                    pstmt.setString(3, name);
                    pstmt.setString(4, dob);
                    pstmt.setString(5, gender);
                    pstmt.setString(6, occupation);
                    pstmt.setString(7, city);
                    pstmt.setString(8, mobile);

                    pstmt.executeUpdate();
                }
            }
            // On successful registration, redirect to login page
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.html");
        }
    }
}