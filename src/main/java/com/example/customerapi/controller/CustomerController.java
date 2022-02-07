package com.example.customerapi.controller;

import com.example.customerapi.model.Customer;
import com.example.customerapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public void addNewCustomer(@RequestBody Customer customer) throws Exception {
        this.customerService.addNewCustomer(customer);
    }

    @GetMapping("allCustomers")
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @PutMapping("{studentId}")
    public Customer updateCustomer(@PathVariable("studentId") Long id, @RequestParam String name, @RequestParam String email) throws Exception {
        return this.customerService.updateCustomer(id, name, email);
    }

    @DeleteMapping("{studentId}")
    public void deleteCustomer(@PathVariable("studentId") Long id) throws Exception {
        this.customerService.deleteCustomerById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "tested API";
    }
}
