package com.vesqum.Resourcemanagment.company.employee;

import jakarta.persistence.*;

import java.util.Objects;
/**
 * Model reprezentujący pracownika w systemie zarządzania zasobami ludzkimi.
 * Zawiera podstawowe informacje o pracowniku oraz szczegółowe informacje kontraktowe.
 */

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    /** Szczegółowe informacje o kontrakcie pracownika. */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_details_id", referencedColumnName = "id")
    private EmployeeDetails employeeDetails;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phone, EmployeeDetails employeeDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.employeeDetails = employeeDetails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone) && Objects.equals(employeeDetails, employee.employeeDetails);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, employeeDetails);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeDetails=" + employeeDetails +
                '}';
    }
}
