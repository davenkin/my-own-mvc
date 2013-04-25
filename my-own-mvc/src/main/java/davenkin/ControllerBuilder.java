package davenkin;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/25/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ControllerBuilder {
    private final Controller controller;

    public ControllerBuilder() {
        controller = new Controller();
    }

    public static ControllerBuilder controller() {
        return new ControllerBuilder();
    }

    public ControllerBuilder acceptUrl(String url) {
        controller.setUrl(url);
        return this;
    }

    public ControllerBuilder registerHandler(RequestHandler handler) {
        controller.addHandler(handler);
        return this;
    }

    public Controller build() {
        return controller;
    }


}
