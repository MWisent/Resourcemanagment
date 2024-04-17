package com.vesqum.Resourcemanagment.company.employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repozytorium dla encji Employee, zapewniające dostęp do bazy danych.
 * Wykorzystuje Spring Data JPA do automatyzacji operacji CRUD i innych zapytań bazodanowych.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
