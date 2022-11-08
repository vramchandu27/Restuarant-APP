package com.customer.repository;

import com.customer.model.Customer;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    List<Customer>findByCustomerName(String customerName);
}
