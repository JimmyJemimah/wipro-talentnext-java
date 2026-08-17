import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opParam = request.getParameter("operation");
        String targetPage = "error.jsp";

        if (opParam != null) {
            try {
                int value = Integer.parseInt(opParam);
                if (value < 10) {
                    targetPage = "page1.jsp";
                } else if (value >= 10 && value < 99) {
                    targetPage = "page2.jsp";
                }
            } catch (NumberFormatException e) {
                targetPage = "error.jsp";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }
}