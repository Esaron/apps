package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class WoLServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -3385386385030875197L;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("<h1>Hi! Click the button below to turn on the server!</h1>");
        sb.append("<form ACTION=\"/wake/perform\" METHOD=\"POST\">");
        sb.append("<input name=\"send\"  type=\"submit\"  value=\"Wake Server\" />");
        sb.append("</form>");
        sb.append("</body>");
        sb.append("</html>");
        out.println(sb.toString());
    }
}
