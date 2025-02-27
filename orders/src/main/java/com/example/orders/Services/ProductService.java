package com.example.orders.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orders.DTO.ProductDTO;
import com.example.orders.Entities.Product;
import com.example.orders.Repositories.ProductRepository;
import com.example.orders.Services.Utils.MappingUtils;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MappingUtils mp;
    private Integer quantity=10;
    public void deleverToWarehouse(List<ProductDTO>products){
        products.forEach(product->product.setQuantity(quantity));
    }
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(mp::mapToProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> findById(Long id) {
        return productRepository.findById(id).stream().map(mp::mapToProductDTO).collect(Collectors.toList());
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }
        else{
            throw new RuntimeException("Product not found!"); 
        }
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}