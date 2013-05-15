package davenkin.customer.service;

import davenkin.customer.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
}
