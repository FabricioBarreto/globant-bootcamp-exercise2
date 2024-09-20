package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

}
