package com.example.orders.Services.Utils;

import org.springframework.stereotype.Service;

import com.example.orders.DTO.CustomerDTO;
import com.example.orders.DTO.OrderDTO;
import com.example.orders.DTO.ProductDTO;
import com.example.orders.Entities.Customer;
import com.example.orders.Entities.Order;
import com.example.orders.Entities.Product;

@Service
public class MappingUtils {
    public ProductDTO mapToProductDTO(Product product){
        ProductDTO pDTO = new ProductDTO();
        pDTO.setId(product.getID());
        pDTO.setName(product.getName());
        pDTO.setPrice(product.getPrice());
        return pDTO;
    }
    public CustomerDTO mapToCustomerDTO(Customer customer){
        CustomerDTO cDTO = new CustomerDTO();
        cDTO.setId(customer.getId());
        cDTO.setName(customer.getName());
        return cDTO;
    }
    public OrderDTO mapToOrderDTO(Order order){
        OrderDTO oDTO = new OrderDTO();
        oDTO.setId(order.getID());
        oDTO.setCustomer(order.getCustomer());
        return oDTO;
    }
    public Product mapToProduct(ProductDTO pDTO){
        Product product = new Product();
        product.setID(pDTO.getId());
        product.setName(pDTO.getName());
        product.setPrice(pDTO.getPrice());
        return product;
    }
    public Customer mapToCustomer(CustomerDTO cDTO){
        Customer customer = new Customer();
        customer.setId(cDTO.getId());
        customer.setName(cDTO.getName());
        return customer;
    }
    public Order mapToOrder(OrderDTO oDTO){
        Order order = new Order();
        order.setId(oDTO.getId());
        order.setCustomer(oDTO.getCustomer());
        return order;
    }
}
