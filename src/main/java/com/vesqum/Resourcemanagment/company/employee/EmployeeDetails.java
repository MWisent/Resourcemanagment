package com.vesqum.Resourcemanagment.company.employee;

import com.vesqum.Resourcemanagment.company.employee.ContractType;
import com.vesqum.Resourcemanagment.company.employee.Employee;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * Model reprezentujący pracownika w systemie zarządzania zasobami ludzkimi.
 * Zawiera szczegółowe informacje o pracowniku oraz szczegółowe informacje kontraktowe.
 */

@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ContractType contractType;
    private BigDecimal salary;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    public EmployeeDetails() {}

    public EmployeeDetails(ContractType contractType,
                           BigDecimal salary,
                           LocalDate contractStartDate,
                           LocalDate contractEndDate,
                           Employee employee) {
        this.contractType = contractType;
        this.salary = salary;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.employee = employee;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "contractType=" + contractType +
                ", salary=" + salary +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", employee=" + employee +
                '}';
    }
}
