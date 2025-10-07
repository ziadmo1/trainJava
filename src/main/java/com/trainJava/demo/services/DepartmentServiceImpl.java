package com.trainJava.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainJava.demo.abstracts.DepartmentsService;
import com.trainJava.demo.dtos.CreateDepartmentDto;
import com.trainJava.demo.entities.Department;
import com.trainJava.demo.repositories.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department createDepartment(CreateDepartmentDto departmentDto) {
        var department = new Department();
        department.setArName(departmentDto.getArName());
        department.setEnName(departmentDto.getEnName());
        departmentRepo.save(department);
        return department;
    }

    @Override
    public Department getDepartmentById(UUID id) {
        return departmentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
