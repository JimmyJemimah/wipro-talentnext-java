import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BidServlet")
public class BidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        BidBean bid = new BidBean();
        bid.setItemId(request.getParameter("itemId"));
        bid.setItemName(request.getParameter("itemName"));
        bid.setName(request.getParameter("name"));
        bid.setEmail(request.getParameter("email"));
        
        String amountStr = request.getParameter("amount");
        bid.setAmount(amountStr != null && !amountStr.trim().isEmpty() ? Double.parseDouble(amountStr) : 0.0);
        
        String autoIncStr = request.getParameter("autoIncrement");
        bid.setAutoIncrement("true".equalsIgnoreCase(autoIncStr));

        request.setAttribute("bidBean", bid);
        request.getRequestDispatcher("bidResult.jsp").forward(request, response);
    }
}