package com.vesqum.Resourcemanagment.company.Product;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Model reprezentujący produktu w systemie zarządzania zasobami ludzkimi.
 * Zawiera szczegółowe informacje o produkcie .
 */
@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String productValue;
    private int quantity;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    public ProductDetails() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return productValue;
    }

    public void setValue(String productValue) {
        this.productValue = productValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "name='" + name + '\'' +
                ", value='" + productValue + '\'' +
                ", quantity=" + quantity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", product=" + product +
                '}';
    }
}
