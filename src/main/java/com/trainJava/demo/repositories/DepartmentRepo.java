package com.trainJava.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainJava.demo.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, UUID> {

}
