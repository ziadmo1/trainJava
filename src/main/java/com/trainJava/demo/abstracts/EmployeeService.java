package com.trainJava.demo.abstracts;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.trainJava.demo.dtos.CreateEmployeeDTO;
import com.trainJava.demo.entities.Employee;

public interface EmployeeService {

    Employee createEmployee(CreateEmployeeDTO employeeDto);

    Page<Employee> getEmployees(int number, int size);

    Employee getEmployeeById(UUID id);

    void deleteEmployee(UUID id);

    Employee updateEmployee(UUID id, CreateEmployeeDTO employeeDto);
}
