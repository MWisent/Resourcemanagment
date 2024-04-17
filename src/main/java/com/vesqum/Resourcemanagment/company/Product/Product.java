package com.vesqum.Resourcemanagment.company.Product;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
/**
 * Model reprezentujący produkt w systemie zarządzania zasobami w firmie.
 * Zawiera podstawowe informacje o produkcie oraz szczegółowe informacje produktowe.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetails> productDetails;

    public Product() {
    }

    public Product(String name, BigDecimal price, String description, List<ProductDetails> productDetails) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productDetails = productDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDetails>  getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails>  productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productDetails=" + productDetails +
                '}';
    }
}
