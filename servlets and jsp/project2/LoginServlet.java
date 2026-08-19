import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            handleLogin(request, response);
        } else if ("register".equals(action)) {
            handleRegister(request, response);
        } else if ("changePassword".equals(action)) {
            handleChangePassword(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("message", "Invalid username or password!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES(?, ?)");
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();

            request.setAttribute("message", "Registration successful! Please login.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", "User registration failed! Username already exists.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleChangePassword(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE users SET password=? WHERE username=? AND password=?");
            ps.setString(1, newPass);
            ps.setString(2, user);
            ps.setString(3, oldPass);

            int updated = ps.executeUpdate();
            if (updated > 0) {
                request.setAttribute("message", "Password updated successfully! Please login with your new password.");
            } else {
                request.setAttribute("message", "Invalid username or old password!");
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}