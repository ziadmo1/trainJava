package com.trainJava.demo.dtos;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateEmployeeDTO {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must be at least 2 characters long")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must be at least 2 characters long")
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Size(min = 5, message = "Email must be at least 5 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email must be a valid format")
    private String email;
    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, message = "Phone number must be at least 10 characters long")
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Phone number must be a valid format")
    private String phoneNumber;
    @NotNull(message = "Position cannot be null")
    @Size(min = 2, message = "Position must be at least 2 characters long")
    private String position;
    @NotNull(message = "Hire date cannot be null")
    private LocalDate hireDate;
    @NotNull(message = "Department ID cannot be null")
    private UUID departmentId;

}
