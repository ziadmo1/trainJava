package com.trainJava.demo.services;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainJava.demo.abstracts.ForgotPassService;
import com.trainJava.demo.dtos.ForgotPassDto;
import com.trainJava.demo.entities.Employee;
import com.trainJava.demo.entities.ForgotPass;
import com.trainJava.demo.repositories.EmployeeRepo;
import com.trainJava.demo.shared.CustomResponseExc;

import jakarta.transaction.Transactional;

@Service
public class ForgotPassServiceImpl implements ForgotPassService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmailService emailService;
    private final SecureRandom secureRandom = new SecureRandom();
    // @Autowired
    // private StringRedisTemplate redisTemplate;

    @Transactional
    @Override
    public ForgotPass processForgotPassword(ForgotPassDto forgotPassDto) {
        var entity = new ForgotPass();
        Employee employee = employeeRepo.findByEmail(forgotPassDto.getEmail()).orElseThrow(() -> CustomResponseExc.errorRes("Employee not found"));
        String otp = String.valueOf(5555 + secureRandom.nextInt(9999));
        entity.setEmployee(employee);
        // redisTemplate.opsForValue().set(employee.getId().toString(), otp, 5, TimeUnit.MINUTES);
        emailService.sendEmail(otp, employee.getEmail());
        return entity;
    }

}
