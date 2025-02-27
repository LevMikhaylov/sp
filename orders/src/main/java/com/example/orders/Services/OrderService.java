package com.example.orders.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orders.DTO.OrderDTO;
import com.example.orders.Entities.Order;
import com.example.orders.Repositories.OrderRepository;
import com.example.orders.Services.Utils.MappingUtils;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MappingUtils mappingUtils;


    private Integer quantity = 10;
    public void makeOrder(List<OrderDTO> orders){
        orders.forEach(
            order->order.setQuantity(quantity)
        );
    }
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                     .map(mappingUtils::mapToOrderDTO)
                     .collect(Collectors.toList());
    }

    public List<OrderDTO> findByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
                     .map(mappingUtils::mapToOrderDTO)
                     .collect(Collectors.toList());
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mappingUtils.mapToOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return mappingUtils.mapToOrderDTO(savedOrder);
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        if (orderRepository.existsById(orderId)) {
            updatedOrderDTO.setId(orderId); 
            Order updatedOrder = mappingUtils.mapToOrder(updatedOrderDTO);
            Order savedOrder = orderRepository.save(updatedOrder);
            return mappingUtils.mapToOrderDTO(savedOrder);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public void deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    public List<OrderDTO> findByStatus(String status) {
        List<Order> orders = orderRepository.findByStatus(status);
        return orders.stream()
                     .map(mappingUtils::mapToOrderDTO)
                     .collect(Collectors.toList());
    }

    public List<OrderDTO> findByDate(LocalDate date) {
        List<Order> orders = orderRepository.findByDate(date);
        return orders.stream()
                     .map(mappingUtils::mapToOrderDTO)
                     .collect(Collectors.toList());
    }

    public List<OrderDTO> getAllOrders() {
        return findAll();
    }
}
