package com.trainJava.demo.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateLeaveRequestDto {

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;

    @NotNull(message = "Reason cannot be null")
    private String reason;

    @NotNull(message = "Status cannot be null")
    private String status;

}
