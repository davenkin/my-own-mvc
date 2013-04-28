package davenkin.customer.service;

import davenkin.customer.dao.DefaultCustomerDao;
import davenkin.customer.domain.Customer;

import java.util.List;

public class DefaultCustomerService implements CustomerService {

    private DefaultCustomerDao customerDao;


    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public void setCustomerDao(DefaultCustomerDao customerDao) {
        this.customerDao = customerDao;
    }


}
