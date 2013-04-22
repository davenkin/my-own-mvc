package davenkin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestDispatcher extends HttpServlet {
    private NotJustMeltContainer container;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object object = container.getMappingObject(req);
    }

    public void init() {
         new com.melt.core.Container();
    }


}
