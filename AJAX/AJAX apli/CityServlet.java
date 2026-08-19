package com.wipro.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Static map containing state-to-cities mapping
    private static final Map<String, List<String>> stateCityMap = new HashMap<>();

    static {
        stateCityMap.put("Maharashtra", Arrays.asList("Mumbai", "Pune", "Nagpur", "Nashik"));
        stateCityMap.put("Karnataka", Arrays.asList("Bengaluru", "Mysuru", "Hubballi", "Mangaluru"));
        stateCityMap.put("TamilNadu", Arrays.asList("Chennai", "Coimbatore", "Madurai", "Tiruchirappalli"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String state = request.getParameter("state");

        if (state != null && stateCityMap.containsKey(state)) {
            List<String> cities = stateCityMap.get(state);

            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>S.No</th><th>City Name</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            
            int sno = 1;
            for (String city : cities) {
                out.println("<tr>");
                out.println("<td>" + (sno++) + "</td>");
                out.println("<td>" + city + "</td>");
                out.println("</tr>");
            }
            
            out.println("</tbody>");
            out.println("</table>");
        } else {
            out.println("<p>No cities found for the selected state.</p>");
        }
    }
}