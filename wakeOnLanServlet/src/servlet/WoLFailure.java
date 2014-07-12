package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class WoLFailure extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = -5701361868118079329L;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("Something went wrong! Try again in a few mintues.");
        sb.append("</body>");
        sb.append("</html>");
        out.println(sb.toString());
    }
    
}
