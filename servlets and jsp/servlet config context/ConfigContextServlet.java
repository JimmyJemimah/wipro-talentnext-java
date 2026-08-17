import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/ConfigContextServlet",
    initParams = {
        @WebInitParam(name = "servletEmail", value = "admin@servlet.com"),
        @WebInitParam(name = "maxUploadSize", value = "10MB")
    }
)
public class ConfigContextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Config and Context Parameters</title></head><body>");

        // 1. Fetching ServletConfig Initialization Parameters
        ServletConfig config = getServletConfig();
        out.println("<h2>ServletConfig (Init Parameters)</h2>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr bgcolor='#cccccc'><th>Parameter Name</th><th>Parameter Value</th></tr>");

        Enumeration<String> configParams = config.getInitParameterNames();
        while (configParams.hasMoreElements()) {
            String paramName = configParams.nextElement();
            String paramValue = config.getInitParameter(paramName);
            out.println("<tr><td>" + paramName + "</td><td>" + paramValue + "</td></tr>");
        }
        out.println("</table><br>");

        // 2. Fetching ServletContext Parameters
        ServletContext context = getServletContext();
        out.println("<h2>ServletContext (Context Parameters)</h2>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr bgcolor='#cccccc'><th>Parameter Name</th><th>Parameter Value</th></tr>");

        Enumeration<String> contextParams = context.getInitParameterNames();
        while (contextParams.hasMoreElements()) {
            String paramName = contextParams.nextElement();
            String paramValue = context.getInitParameter(paramName);
            out.println("<tr><td>" + paramName + "</td><td>" + paramValue + "</td></tr>");
        }
        out.println("</table>");

        out.println("</body></html>");
    }
}