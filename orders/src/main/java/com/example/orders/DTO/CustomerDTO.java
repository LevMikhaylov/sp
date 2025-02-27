package com.example.orders.DTO;




import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    Long id;
    String name;
    @Size(min = 2)
    String surname;
    String patr;
    String phoneNumber;
}
