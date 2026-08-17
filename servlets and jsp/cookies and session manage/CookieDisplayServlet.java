import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDisplayServlet")
public class CookieDisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><head><title>Available Cookies</title></head><body>");
        out.println("<h2>Application Cookies</h2>");

        if (cookies == null || cookies.length == 0) {
            out.println("<h3>No Cookies</h3>");
        } else {
            out.println("<table border='1' cellpadding='5' cellspacing='0'>");
            out.println("<tr bgcolor='#cccccc'><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
            }
            out.println("</table>");
        }

        out.println("</body></html>");
    }
}