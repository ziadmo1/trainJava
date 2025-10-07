package com.trainJava.demo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateDepartmentDto {
    
    @NotNull(message = "Arabic name cannot be null")
    private String arName;
    @NotNull(message = "English name cannot be null")
    private String enName;

}
