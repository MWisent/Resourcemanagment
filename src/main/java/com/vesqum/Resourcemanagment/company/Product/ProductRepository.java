package com.vesqum.Resourcemanagment.company.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium dla encji Product, zapewniające dostęp do bazy danych.
 * Wykorzystuje Spring Data JPA do automatyzacji operacji CRUD i innych zapytań bazodanowych.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
