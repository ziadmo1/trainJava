package com.trainJava.demo.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trainJava.demo.abstracts.UserAccountService;
import com.trainJava.demo.dtos.UserAccountDto;
import com.trainJava.demo.entities.UserAccount;
import com.trainJava.demo.repositories.EmployeeRepo;
import com.trainJava.demo.repositories.UserAccountRepo;
import com.trainJava.demo.shared.CustomResponseExc;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepo userAccountRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserAccount createUserAccount(UserAccountDto userAccountDto, UUID employeeId) {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(userAccountDto.getUsername());
        userAccount.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));
        var employee = employeeRepo.findByEmployeeToken(employeeId).orElseThrow(() -> CustomResponseExc.errorRes("Employee not found"));
        userAccount.setEmployee(employee);
        if (employee.getExpDate().isBefore(LocalDateTime.now())) {
            throw CustomResponseExc.errorRes("Employee contract has expired");
        }
        userAccountRepo.save(userAccount);
        return userAccount;
    }

    @Override
    public String loginUser(UserAccountDto userAccountDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userAccountDto.getUsername(), userAccountDto.getPassword()
            ));
            var claims = new HashMap<String, Object>();
            claims.put("name", userAccountDto.getUsername());
            claims.put("role", "USER");
            return "'jwtHelper.generatToken(claims, userAccountDto)'";
        } catch (AuthenticationException e) {
            throw CustomResponseExc.invalidCredentials(e.getMessage());
        }
    }

}
