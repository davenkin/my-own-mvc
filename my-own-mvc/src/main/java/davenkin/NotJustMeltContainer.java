package davenkin;

import com.melt.core.Container;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/22/13
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotJustMeltContainer {
    private Container meltContainer;

    public Object getMappingObject(HttpServletRequest req) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public <T> T resolve(Class targetClass) {
        return meltContainer.resolve(targetClass);
    }

    public void setMeltContainer(Container meltContainer) {
        this.meltContainer = meltContainer;
    }
}
