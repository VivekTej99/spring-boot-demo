package com.hrchain.service;

import com.hrchain.model.Customer;
import com.hrchain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public record CustomerResponse(List<Customer> content){}
    
    public CustomerResponse returnAllCustomers() throws Exception {
        List<Customer> customerList;
        try {
            customerList = this.customerRepository.findAll();

        }catch (Exception e){
            throw new Exception("Error in db");
        }
        return new CustomerResponse(customerList);
    }

    public void createCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer id){
        this.customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Integer id, Customer customer) throws Exception {
        Customer customer1 = this.customerRepository.findById(id)
                .orElseThrow(()-> new Exception());

        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        customer1.setAge(customer.getAge());
        return this.customerRepository.save(customer1);
    }
}
