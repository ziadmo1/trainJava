package com.trainJava.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainJava.demo.abstracts.ForgotPassService;
import com.trainJava.demo.dtos.ForgotPassDto;
import com.trainJava.demo.entities.ForgotPass;
import com.trainJava.demo.entities.GlobalRes;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ForgotPassController {

    @Autowired
    private ForgotPassService forgotPassService;

    @PostMapping("/forgot-password")
    public ResponseEntity<GlobalRes<ForgotPass>> forgotPassword(@Valid @RequestBody ForgotPassDto dto) {
        var res = forgotPassService.processForgotPassword(dto);
        return ResponseEntity.ok(new GlobalRes<>("Otp sent successfully to " + dto.getEmail(), res));
    }

}
