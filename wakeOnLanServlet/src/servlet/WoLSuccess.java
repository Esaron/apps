package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class WoLSuccess extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5031960182400372792L;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("The server is up!");
        sb.append("</body>");
        sb.append("</html>");
        out.println(sb.toString());
    }

}
