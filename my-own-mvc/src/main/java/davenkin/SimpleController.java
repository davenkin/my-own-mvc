package davenkin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleController {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head><title>Hello World</title></title>");
        pw.println("<body>");
        pw.println("<h1>Hello World</h1>");
        pw.println("</body></html>");
    }
}
