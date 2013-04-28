package davenkin.customer.dao;

import davenkin.customer.domain.Customer;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class DefaultCustomerDao implements CustomerDao {

    public List<Customer> findAll() {
        return newArrayList(createCustomer(123, "Tom"), createCustomer(456, "Kate"), createCustomer(789, "Jerry"));
    }

    private Customer createCustomer(int id, String name) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }

}
