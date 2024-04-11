package com.vesqum.Resourcemanagment.company.employee;

import com.vesqum.Resourcemanagment.company.employee.Employee;

import java.util.List;

import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> getEmployeeById(Long id);
    void createEmployee(Employee employee);

    boolean deleteEmployee(Long employeeId);

    Employee updateEmployee(Long id, Employee employee);
}
