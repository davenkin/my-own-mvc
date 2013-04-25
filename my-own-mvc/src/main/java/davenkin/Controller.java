package davenkin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/25/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public final class Controller {

    private String url;
    private List<RequestHandler> handlers = new ArrayList<RequestHandler>();

    public void setUrl(String url) {
        this.url = url;
    }

    public void addHandler(RequestHandler handler) {
        handlers.add(handler);
    }
}
