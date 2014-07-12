package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WokenServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 2251845740506495539L;
    private static long lastSuccessTime = 0;

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        long currentTime = System.currentTimeMillis();
        String destination;
        if (currentTime - lastSuccessTime > 30*60*1000) {
            Process p = Runtime.getRuntime().exec("sudo etherwake [macAddress]");
            int exitCode = 1;
            try
            {
                exitCode = p.waitFor();
            }
            catch (InterruptedException e)
            {
                // no-op
            }
            finally {
                if (exitCode == 0) {
                    System.out.println("Success!");
                    lastSuccessTime = currentTime;
                    destination = "/wake/success";
                }
                else {
                    System.out.println("Failure!");
                    destination = "/wake/failure";
                }
                seeOther(response, destination);
            }
        }
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("You can't wake up the server right now! Try again later.");
        sb.append("</body>");
        sb.append("</html>");
        out.println(sb.toString());
    }

    private void seeOther(HttpServletResponse resp, String pathOfOtherToSee) {
        resp.setStatus(HttpServletResponse.SC_SEE_OTHER);
        resp.setHeader("Location", pathOfOtherToSee);
    }

}
