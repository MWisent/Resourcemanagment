package com.vesqum.Resourcemanagment.company.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Kontroler REST dla pracowników.
 * Odpowiada za obsługę żądań HTTP dotyczących operacji na danych pracowników.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /**
     * Pobiera Listę pracowników.
     *
     * @param employeeId identyfikator pracownika
     * @return ResponseEntity z listą pracownikóœ lub odpowiedź 404, jeśli listy nie został znaleziona
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }
    /**
     * Pobiera pracownika o podanym ID.
     *
     * @param employeeId identyfikator pracownika
     * @return ResponseEntity z pracownikiem lub odpowiedź 404, jeśli pracownik nie został znaleziony
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
    }

    /**
     * Aktualizuje pracownika o podanym ID nowymi danymi.
     *
     * @param employeeId identyfikator pracownika do aktualizacji
     * @param employeeDetails nowe dane pracownika
     * @return ResponseEntity z zaktualizowanym pracownikiem lub odpowiedź 404, jeśli pracownik nie został znaleziony
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeService.updateEmployee(employeeId, employeeDetails);
        return ResponseEntity.ok(updateEmployee);
    }
    /**
     * Usuwa pracownika o podanym ID z bazy danych.
     * Metoda nie rzuca wyjątku, nawet jeśli pracownik o danym ID nie istnieje,
     * aby zachować idempotentność operacji DELETE.
     *
     * @param id identyfikator pracownika do usunięcia
     * @return zwraca HTTP z kodem statusu 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }


}
