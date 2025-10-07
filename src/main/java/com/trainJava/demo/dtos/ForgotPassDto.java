package com.trainJava.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ForgotPassDto {
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
}
