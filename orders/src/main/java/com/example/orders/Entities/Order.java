package com.example.orders.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name="Orders")
@Accessors(chain = true)
@Data
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "order_product", 
      joinColumns = @JoinColumn(name = "order_id"), 
      inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    // Constructors, getters, and setters

    public Order() {
        this.creationDate = LocalDate.now(); // устанавливаем дату создания при создании заказа
    }

    public void setId(Long orderId) {
        this.id=orderId;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public Long getID(){
        return this.id;
    }
    public OrderStatus getStatus(){
        return this.status;
    }
} enum OrderStatus {
    DELIVERED,
    CREATED,
    CANCELED
}
