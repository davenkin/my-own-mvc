package customer.web;

import customer.domain.Customer;
import customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;


public class CustomerServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(CustomerServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        WebApplicationContext context = (WebApplicationContext) getServletConfig().getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");

        CustomerService customerService = (CustomerService) context.getBean("customerService");
        List<Customer> allCustomers = customerService.getAllCustomers();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        printCustomers(allCustomers, out);

        printServletContextAttributes(out);

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

    private void printServletContextAttributes(PrintWriter out) {
        out.println("<h1> Servlet Context Attributes: </h1>");
        ServletContext servletContext = getServletConfig().getServletContext();
        Enumeration attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement().toString();
            logger.info(attribute);
            out.println("<h3>" + attribute + ": " + servletContext.getAttribute(attribute).hashCode() + "</h3>");
        }
    }

    private void printRequestAttributes(HttpServletRequest request, PrintWriter out) {
        out.println("<h1> Request Attributes: </h1>");
        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement().toString();
            logger.info(attribute);
            out.println("<h3>" + attribute + ": " + request.getAttribute(attribute).hashCode() + "</h3>");
        }
    }
}
