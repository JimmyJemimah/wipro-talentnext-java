import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Request Parameters</title></head><body>");
        out.println("<h2>All Submitted Request Parameters</h2>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr bgcolor='#cccccc'><th>Parameter Name</th><th>Parameter Value(s)</th></tr>");

        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);

            out.println("<tr><td>" + paramName + "</td><td>");
            if (paramValues.length == 1) {
                out.println(paramValues[0]);
            } else {
                out.println("<ul>");
                for (String value : paramValues) {
                    out.println("<li>" + value + "</li>");
                }
                out.println("</ul>");
            }
            out.println("</td></tr>");
        }

        out.println("</table></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}