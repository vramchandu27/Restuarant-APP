package com.customer.service;

import com.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomer {
    public Customer addCustomer(Customer customer);

    public Optional<Customer> findCustomer(Long customerId) throws Exception;

    public List<Customer> findCustomer(String customerName) throws Exception;
}
