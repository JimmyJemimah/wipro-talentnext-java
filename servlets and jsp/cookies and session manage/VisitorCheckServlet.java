import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitorCheckServlet")
public class VisitorCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        boolean isVisited = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visited".equals(cookie.getName())) {
                    isVisited = true;
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (isVisited) {
            out.println("<h2>Welcome Back</h2>");
        } else {
            out.println("<h2>Welcome, you are visiting for the first time</h2>");
            Cookie visitorCookie = new Cookie("visited", "true");
            visitorCookie.setMaxAge(24 * 60 * 60); // Valid for 24 hours
            response.addCookie(visitorCookie);
        }
        out.println("</body></html>");
    }
}