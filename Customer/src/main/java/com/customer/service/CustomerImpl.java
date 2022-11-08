package com.customer.service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements ICustomer{
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findCustomer(Long customerId) throws Exception {
        if(customerRepo.findById(customerId).isEmpty()){
            throw new Exception("No Record Found");
        }else {
            return customerRepo.findById(customerId);
        }
    }

    @Override
    public List<Customer> findCustomer(String customerName) throws Exception {
        if(customerRepo.findByCustomerName(customerName).isEmpty()){
            throw new Exception("No Record Found");
        }else {
            return customerRepo.findByCustomerName(customerName);
        }
    }
}
