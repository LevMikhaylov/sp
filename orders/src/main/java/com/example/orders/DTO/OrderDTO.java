package com.example.orders.DTO;

import com.example.orders.Entities.Customer;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class OrderDTO {
    Long id;
    Customer customer;
    @PositiveOrZero
    int quantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
enum OrderStatus {
    DELIVERED,
    CREATED,
    CANCELED
}