package com.vesqum.Resourcemanagment.company.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServer {
    List<Product> findAll();

    void createProduct(Product product);

    Optional<Product> getEmployeeById(Long id);

    Product updateProduct(Long productId, Product productDetails);

    void deleteProduct(Long productId);
}
