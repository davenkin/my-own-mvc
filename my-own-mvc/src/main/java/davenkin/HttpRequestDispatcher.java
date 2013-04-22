package davenkin;

import com.melt.core.Container;
import com.melt.core.ContainerBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestDispatcher extends HttpServlet {

    public static final String CONTAINER = "MELT_CONTAINER";

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        NotJustMeltContainer container = (NotJustMeltContainer) this.getServletContext().getAttribute(CONTAINER);
        SimpleController controller = container.resolve(SimpleController.class);

        try {
            controller.doGet(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        NotJustMeltContainer container = new NotJustMeltContainer();
        Container meltContainer = new ContainerBuilder().register(SimpleController.class).build();
        container.setMeltContainer(meltContainer);
        this.getServletContext().setAttribute(CONTAINER, container);
    }


}
