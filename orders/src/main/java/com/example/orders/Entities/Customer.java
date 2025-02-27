package com.example.orders.Entities;

import java.util.List;

import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SuppressWarnings("unused")
    @Column
    @Size(min = 2)
    private String name;
    @Pattern(regexp="\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$", message="Invalid phone number format")//Задаём формат номера телефона в России
    private String phoneNumber;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
    public void setId(Long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
}
