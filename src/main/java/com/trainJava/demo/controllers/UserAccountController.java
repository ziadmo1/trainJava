package com.trainJava.demo.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainJava.demo.abstracts.UserAccountService;
import com.trainJava.demo.dtos.UserAccountDto;
import com.trainJava.demo.entities.GlobalRes;
import com.trainJava.demo.entities.UserAccount;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/create")
    public ResponseEntity<GlobalRes<UserAccount>> createUserAccount(@Valid @RequestBody UserAccountDto userAccountDto, @Valid @RequestParam UUID employeeId) {
        var account = userAccountService.createUserAccount(userAccountDto, employeeId);
        return ResponseEntity.ok(new GlobalRes<>("User account created successfully", account));

    }

    @PostMapping("/login")
    public ResponseEntity<GlobalRes<String>> loginUser(@Valid @RequestBody UserAccountDto userAccountDto) {
        var token = userAccountService.loginUser(userAccountDto);
        return ResponseEntity.ok(new GlobalRes<>(null, token));
    }

}
