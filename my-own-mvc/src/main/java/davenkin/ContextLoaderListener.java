package davenkin;

import com.melt.core.Container;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/27/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContextLoaderListener implements ServletContextListener {

    public static final String ROOT_CONTAINER = "ROOT_CONTAINER";
    public static final String CONTAINER_CONFIG_LOCATION = "containerConfigLocation";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        String configLocation = context.getInitParameter(CONTAINER_CONFIG_LOCATION);

        context.setAttribute(ROOT_CONTAINER, createRootContainer(configLocation));
    }

    private Container createRootContainer(String configLocation) {
        return new ClasspathXmlContainerBuilder().build("/" + configLocation);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
