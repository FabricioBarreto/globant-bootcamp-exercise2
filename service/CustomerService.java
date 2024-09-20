package service;

import model.Customer;

public interface CustomerService {

    public Customer createCustomer(Long id, String name, String lastName, String birthDate, String email, String phone);

    public Customer getCustomerById(Long id);


}
