package com.example.orders.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orders.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}