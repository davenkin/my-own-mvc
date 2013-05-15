package customer.dao;

import customer.domain.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();
}
