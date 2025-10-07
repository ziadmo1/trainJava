package com.trainJava.demo.controllers;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainJava.demo.abstracts.EmployeeService;
import com.trainJava.demo.dtos.CreateEmployeeDTO;
import com.trainJava.demo.entities.Employee;
import com.trainJava.demo.entities.GlobalRes;
import com.trainJava.demo.entities.PaginatedRes;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<GlobalRes<PaginatedRes<Employee>>> getEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        var employeesResponse = employeeService.getEmployees(page, size);
        var paginatedResponse = new PaginatedRes<>(employeesResponse.getContent(), employeesResponse.getNumber() + 1, employeesResponse.getTotalPages(), employeesResponse.getTotalElements());
        return ResponseEntity.ok(new GlobalRes<>(paginatedResponse));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<GlobalRes<Employee>> getEmployeeById(@PathVariable UUID id) {
        var employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new GlobalRes<>(employee));
    }

    @PostMapping("/create")
    public ResponseEntity<GlobalRes<Employee>> postMethodName(@Valid @RequestBody CreateEmployeeDTO employeeDto) {
        var employee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new GlobalRes<>(employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<GlobalRes<?>> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(new GlobalRes<>("Employee deleted successfully", null));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<GlobalRes<Employee>> putMethodName(@PathVariable UUID id, @Valid @RequestBody CreateEmployeeDTO employeeDto
    ) {
        Employee existingEmployee = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.status(201).body(new GlobalRes<>(existingEmployee));
    }

}
