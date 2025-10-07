package com.trainJava.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainJava.demo.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

    public Optional<Employee> findByEmployeeToken(UUID token);

    public Optional<Employee> findByEmail(String email);

}
