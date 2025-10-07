package com.trainJava.demo.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trainJava.demo.abstracts.EmployeeService;
import com.trainJava.demo.dtos.CreateEmployeeDTO;
import com.trainJava.demo.entities.Employee;
import com.trainJava.demo.repositories.DepartmentRepo;
import com.trainJava.demo.repositories.EmployeeRepo;
import com.trainJava.demo.shared.CustomResponseExc;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmailService emailService;

    @Override
    public Employee createEmployee(CreateEmployeeDTO employeeDto) {
        var employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPosition(employeeDto.getPosition());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setEmployeeToken(UUID.randomUUID());
        var department = departmentRepo.findById(employeeDto.getDepartmentId());
        if (department.isEmpty()) {
            throw CustomResponseExc.errorRes("Department not found");
        }
        employee.setDepartment(department.get());
        employeeRepo.save(employee);
        emailService.sendEmail(employee.getEmployeeToken().toString(), employee.getEmail());
        return employee;
    }

    @Override
    public Page<Employee> getEmployees(int number, int size) {
        Pageable pageable = PageRequest.of(number, size);
        
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepo.findById(id).orElseThrow(() -> CustomResponseExc.errorRes("Employee not found"));
    }

    @Override
    public void deleteEmployee(UUID id) {
        var employee = employeeRepo.findById(id).orElseThrow(() -> CustomResponseExc.errorRes("Employee not found"));
        employeeRepo.delete(employee);
    }

    @Override
    public Employee updateEmployee(UUID id, CreateEmployeeDTO employeeDto) {
        var existingEmployee = employeeRepo.findById(id).orElseThrow(() -> CustomResponseExc.errorRes("Employee not found"));
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setPosition(employeeDto.getPosition());
        existingEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
        existingEmployee.setHireDate(employeeDto.getHireDate());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }

}
