package service.impl;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Customer createCustomer(Long id, String name, String lastName, String birthDate, String email, String phone){
        List<Customer> customers = customerRepository.getCustomers();

        if (customers.stream().anyMatch(customer -> customer.getId().equals(id))) {
            throw new RuntimeException(String.format("Customer with id %d already exists", id));
        }

        Customer customer = new Customer(id, name, lastName, birthDate, email, phone);
        customers.add(customer);

        return customer;

    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomers().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Customer with id %d not found", id)));
    }

}
