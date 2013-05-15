package customer.web;

import customer.domain.Customer;
import customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/28/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    Logger logger = LoggerFactory.getLogger(DefaultController.class);


    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Customer> allCustomers = customerService.getAllCustomers();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        printCustomers(allCustomers, out);

        printServletContextAttributes(request, out);

        printRequestAttributes(request, out);


        out.println("</body>");
        out.println("</html>");

    }

    private void printCustomers(List<Customer> allCustomers, PrintWriter out) {
        out.println("<h1>Customers:</h1>");
        for (Customer customer : allCustomers) {
            out.println("<h3>" + customer.getId() + ": " + customer.getName() + "</h3>");
        }
    }

    private void printRequestAttributes(HttpServletRequest request, PrintWriter out) {
        out.println("<h1> Request Attributes: </h1>");
        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement().toString();
            logger.info(attribute);
            out.println("<p/>");
            out.println("<h3>" + attribute + ": " + request.getAttribute(attribute).hashCode() + "</h3>");
        }
    }

    private void printServletContextAttributes(HttpServletRequest request, PrintWriter out) {
        out.println("<h1> Servlet Context Attributes: </h1>");
        ServletContext servletContext = request.getSession().getServletContext();
        Enumeration attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement().toString();
            logger.info(attribute);
            out.println("<p/>");
            out.println("<h3>" + attribute + ": " + servletContext.getAttribute(attribute).hashCode() + "</h3>");
        }
    }


    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
