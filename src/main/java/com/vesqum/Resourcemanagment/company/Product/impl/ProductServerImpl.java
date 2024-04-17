package com.vesqum.Resourcemanagment.company.Product.impl;

import com.vesqum.Resourcemanagment.company.Product.Product;
import com.vesqum.Resourcemanagment.company.Product.ProductRepository;
import com.vesqum.Resourcemanagment.company.Product.ProductServer;
import com.vesqum.Resourcemanagment.company.employee.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServerImpl implements ProductServer {
    private final ProductRepository productRepository;

    public ProductServerImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /**
     * Wyszukuje cała list produktów.
     *
     * @return zwraca pełną liste produktów lub pustą listę.
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    /**
     * Tworzymy produkt do bazy danych.
     *
     * @param Product Objekt produktu
     * @return Optional zawierający znalezionego produktu lub pusty, jeśli produkt nie został znaleziony
     */
    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
    /**
     * Wyszukuje pracownika po jego ID.
     *
     * @param id identyfikator produktu
     * @return zwraca true jak udało się usunąć produktu lub false gdy nie znaleziono produktu.
     */
    @Override
    public Optional<Product> getEmployeeById(Long id) {
        return productRepository.findById(id);
    }
    /**
     * Aktualizuje dane produktu.
     * Jeśli produkt o danym ID istnieje, aktualizuje jego dane, w przeciwnym razie zapisuje nowego produktu.
     *
     * @param productId identyfikator produktu do aktualizacji
     * @param productDetails dane produktu do aktualizacji
     * @return zaktualizowany lub nowy pracownik
     */
    @Override
    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found " + productId));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setProductDetails(productDetails.getProductDetails());
        return productRepository.save(product);
    }
    /**
     * Wyszukuje produktu po jego ID.
     *
     * @param productId identyfikator produktu
     * @return zwraca true jak udało się usunąć produktu lub false gdy nie znaleziono produktu.
     */
    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found " + productId));
        productRepository.delete(product);
    }
}
