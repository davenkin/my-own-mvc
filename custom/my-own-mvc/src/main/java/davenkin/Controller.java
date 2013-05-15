package davenkin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/25/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Controller {

    public void processRequest(HttpServletRequest request, HttpServletResponse response);
}
