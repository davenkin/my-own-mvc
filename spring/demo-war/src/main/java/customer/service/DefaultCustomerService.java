package customer.service;

import customer.dao.CustomerDao;
import customer.dao.DefaultCustomerDao;
import customer.domain.Customer;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCustomerService implements CustomerService {

    private CustomerDao customerDao;


    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Required
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


}
