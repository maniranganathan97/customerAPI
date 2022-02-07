package com.example.customerapi.service;

import com.example.customerapi.model.Customer;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addNewCustomer(Customer customer) throws Exception {
        Optional<Customer> customerOptional = this.customerRepository.findByEmail(customer.getEmail());
        if(customerOptional.isPresent()) {
            throw new Exception("Sorry this email has taken, please put new email");
        }
        this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer updateCustomer(Long id, String name, String email) throws Exception {
        boolean isExist = this.customerRepository.existsById(id);
        if(!isExist) {
            throw new Exception("There is no customer with id --->"+ id);
        }
        Optional<Customer> customerOptional = this.customerRepository.findById(id);
        Customer availableCustomer = customerOptional.get();
        availableCustomer.setEmail(email);
        availableCustomer.setName(name);
        this.customerRepository.save(availableCustomer);
        return availableCustomer;

    }

    public void deleteCustomerById(Long id) throws Exception {
        boolean isExist = this.customerRepository.existsById(id);
        if(!isExist) {
            throw new Exception("There is no customer with id --->"+ id);
        }
        this.customerRepository.deleteById(id);
    }
}
