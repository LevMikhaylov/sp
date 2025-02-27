package com.example.orders.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orders.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
