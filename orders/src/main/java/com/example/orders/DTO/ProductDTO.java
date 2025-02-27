package com.example.orders.DTO;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductDTO {
    Long id;
    String name;
    @Positive
    double price;
    @PositiveOrZero
    int quantity;
}