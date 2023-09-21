package com.example.dvaraproject.ecom.product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    Product add(Product product);
   Optional<Product> findById(Long productId);
    void delete(Long productId);
    Product update(Product product);
}