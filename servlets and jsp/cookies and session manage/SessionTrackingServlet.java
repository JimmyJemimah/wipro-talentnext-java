import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTrackingServlet")
public class SessionTrackingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount += 1;
        }
        session.setAttribute("visitCount", visitCount);

        out.println("<html><head><title>Session Tracking</title></head><body>");
        out.println("<h2>Session Tracking Details</h2>");
        out.println("<p><b>Total Page Visits:</b> " + visitCount + "</p>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr bgcolor='#cccccc'><th>Session Attribute</th><th>Value</th></tr>");
        out.println("<tr><td>Session ID</td><td>" + session.getId() + "</td></tr>");
        out.println("<tr><td>Is New Session</td><td>" + session.isNew() + "</td></tr>");
        out.println("<tr><td>Creation Time</td><td>" + new Date(session.getCreationTime()) + "</td></tr>");
        out.println("<tr><td>Last Accessed Time</td><td>" + new Date(session.getLastAccessedTime()) + "</td></tr>");
        out.println("<tr><td>Max Inactive Interval</td><td>" + session.getMaxInactiveInterval() + " seconds</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}