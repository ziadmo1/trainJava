package com.trainJava.demo.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPass {

    @JsonProperty("employeeId")
    private Employee employee;

    public UUID getEmployee() {
        return employee.getId();
    }

}
