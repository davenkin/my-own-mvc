package davenkin;

import com.melt.core.Container;
import com.melt.core.ContainerBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestDispatcher extends HttpServlet {

    public static final String CONTAINER = "MELT_CONTAINER";
    private HashMap<String, Object> urlMappedController;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Object controller = getQualifiedController(req.getRequestURL().toString());
        Method method = getQualifiedMethod(req.getRequestURL().toString(), controller);
    }

    private Method getQualifiedMethod(String url, Object controller) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Object getQualifiedController(String url) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public void init() {
        NotJustMeltContainer container = new NotJustMeltContainer();
        Container meltContainer = new ContainerBuilder().register(SimpleController.class).build();
        container.setMeltContainer(meltContainer);
        getServletContext().setAttribute(CONTAINER, container);
        urlMappedController = findController(container);
    }

    private HashMap<String, Object> findController(NotJustMeltContainer container) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }


}
