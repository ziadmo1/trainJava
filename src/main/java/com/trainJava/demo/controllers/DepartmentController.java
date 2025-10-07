package com.trainJava.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainJava.demo.dtos.CreateDepartmentDto;
import com.trainJava.demo.entities.Department;
import com.trainJava.demo.entities.GlobalRes;
import com.trainJava.demo.services.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/departments")
    public ResponseEntity<GlobalRes<List<Department>>> getDepartments() {
        var departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(new GlobalRes<>(departments));

    }

    @PostMapping("/department/create")
    public ResponseEntity<GlobalRes<Department>> createDepartment(@RequestBody CreateDepartmentDto departmentDto) {
        var department = departmentService.createDepartment(departmentDto);
        return ResponseEntity.ok(new GlobalRes<>(department));
    }

}
