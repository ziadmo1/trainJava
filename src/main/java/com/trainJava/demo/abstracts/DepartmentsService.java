package com.trainJava.demo.abstracts;

import java.util.List;
import java.util.UUID;

import com.trainJava.demo.dtos.CreateDepartmentDto;
import com.trainJava.demo.entities.Department;

public interface DepartmentsService {

    Department createDepartment(CreateDepartmentDto department);

    Department getDepartmentById(UUID id);

    List<Department> getAllDepartments();

}
