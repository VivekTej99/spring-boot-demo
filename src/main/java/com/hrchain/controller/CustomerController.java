package com.hrchain.controller;

import com.hrchain.model.Customer;
import com.hrchain.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    CustomerService.CustomerResponse getAllCustomers() throws Exception {
        try {
            return this.customerService.returnAllCustomers();
        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }

    record CustomerRequest(String name, Integer age, String email){}

    @PostMapping
    public void createACustomer(@RequestBody CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setAge(customerRequest.age());
        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        this.customerService.createCustomer(customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        this.customerService.deleteCustomerById(id);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer id, @RequestBody CustomerRequest customerRequest) throws Exception {
        Customer customer = new Customer();

        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        customer.setAge(customerRequest.age());

        Customer updatedCustomer = this.customerService.updateCustomer(id,customer);
        return ResponseEntity.ok(updatedCustomer);

    }


}
