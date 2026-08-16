public package com.talentnext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String userId = (String) session.getAttribute("userId");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET password = ? WHERE userid = ? AND password = ?"
            );
            ps.setString(1, newPass);
            ps.setString(2, userId);
            ps.setString(3, oldPass);

            int updatedRows = ps.executeUpdate();
            if (updatedRows > 0) {
                response.sendRedirect("home.jsp");
            } else {
                response.getWriter().println("Incorrect old password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} {
    
}
