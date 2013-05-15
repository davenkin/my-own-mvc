package davenkin;

import com.melt.core.Container;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static davenkin.ContextLoaderListener.ROOT_CONTAINER;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestDispatcher extends HttpServlet {

    public static final String CONFIG_LOCATION = "configLocation";
    private Container container;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Controller controller = container.resolve(Controller.class);
        controller.processRequest(req, resp);
    }

    public void init() {
    }
}
