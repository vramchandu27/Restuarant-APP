package com.customer.controller;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
import com.customer.service.CustomerImpl;
//import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    private static final HttpStatus HttpStatus = null;

	@Autowired
    private CustomerImpl customerImpl;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        return ResponseEntity.ok(customerImpl.addCustomer(customer));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity login(@PathVariable Long customerId){
        try {
            return ResponseEntity.ok(customerImpl.findCustomer(customerId).orElse(null));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus).body(e.getMessage());
        }

    }

    @GetMapping("/customer/name/{customerName}")
    public ResponseEntity loginByName(@PathVariable String customerName){
        try {
            return ResponseEntity.ok(customerImpl.findCustomer(customerName));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus).body(e.getMessage());
        }

    }
}
