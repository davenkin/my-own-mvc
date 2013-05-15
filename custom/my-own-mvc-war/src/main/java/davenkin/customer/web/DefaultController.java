package davenkin.customer.web;

import davenkin.Controller;
import davenkin.customer.domain.Customer;
import davenkin.customer.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/28/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultController implements Controller {
    private CustomerService customerService;

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> allCustomers = customerService.getAllCustomers();
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Customers:</h1>");
        for (Customer customer : allCustomers) {
            out.println("<h2>" + customer.getId() + ": " + customer.getName() + "</h2>");
        }
        out.println("</body>");
        out.println("</html>");

    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
