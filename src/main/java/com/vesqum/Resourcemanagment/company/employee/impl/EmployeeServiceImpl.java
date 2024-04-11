package com.vesqum.Resourcemanagment.company.employee.impl;

import com.vesqum.Resourcemanagment.company.employee.Employee;
import com.vesqum.Resourcemanagment.company.employee.EmployeeRepository;
import com.vesqum.Resourcemanagment.company.employee.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    /**
     * Wyszukuje cała list pracowników.
     *
     * @return zwraca pełną liste pracowników lub pustą listę.
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /**
     * Wyszukuje pracownika po jego ID.
     *
     * @param id identyfikator pracownika
     * @return Optional zawierający znalezionego pracownika lub pusty, jeśli pracownik nie został znaleziony
     */
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    /**
     * Tworzymy pracownika do bazy danych.
     *
     * @param Employee Objekt pracownika
     * @return Optional zawierający znalezionego pracownika lub pusty, jeśli pracownik nie został znaleziony
     */
    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    /**
     * Wyszukuje pracownika po jego ID.
     *
     * @param id identyfikator pracownika
     * @return zwraca true jak udało się usunąć pracownika lub false gdy nie znaleziono pracownika.
     */

    @Override
    public boolean deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        else {
            return false;
        }

    }
    /**
     * Aktualizuje dane pracownika.
     * Jeśli pracownik o danym ID istnieje, aktualizuje jego dane, w przeciwnym razie zapisuje nowego pracownika.
     *
     * @param id identyfikator pracownika do aktualizacji
     * @param employeeDetails dane pracownika do aktualizacji
     * @return zaktualizowany lub nowy pracownik
     */
    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setEmployeeDetails(employeeDetails.getEmployeeDetails());
        return employeeRepository.save(employee);
    }

}
