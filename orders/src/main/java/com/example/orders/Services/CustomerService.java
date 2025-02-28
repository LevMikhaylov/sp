package com.example.orders.Services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.orders.DTO.CustomerDTO;
import com.example.orders.Entities.Customer;
import com.example.orders.Repositories.CustomerRepository;
import com.example.orders.Services.Utils.MappingUtils;

import jakarta.validation.Valid;
@Service
@Validated
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MappingUtils mp;
    private String surname = "Алёшин";
    private String patr = "Алекссевич";
    private String phoneNumber = "+75666789090";
    public void makeCustomer(List<CustomerDTO> customers){
        customers.forEach(
        customer->
        {
            customer.setSurname(surname);
            customer.setPatr(patr);
            customer.setPhoneNumber(phoneNumber);
        });
    }
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(mp::mapToCustomerDTO).collect(Collectors.toList());
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(@Valid Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String name, Long id, @Valid Customer updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setName(name);
            return customerRepository.save(updatedCustomer);
        } else {
            throw new RuntimeException("Customer not found!"); 
        }
    }

    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }
}
