package com.mehmetcaliskan.carrentalapp.service;

import com.mehmetcaliskan.carrentalapp.entity.Customer;
import com.mehmetcaliskan.carrentalapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setSurname(customer.getSurname());
        customer1.setPassword(customer.getPassword());
        return customerRepository.save(customer1);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
