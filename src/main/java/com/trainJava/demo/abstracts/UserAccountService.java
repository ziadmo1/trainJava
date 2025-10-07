package com.trainJava.demo.abstracts;

import java.util.UUID;

import com.trainJava.demo.dtos.UserAccountDto;
import com.trainJava.demo.entities.UserAccount;

public interface UserAccountService {

    UserAccount createUserAccount(UserAccountDto userAccountDto, UUID employeeId);

    String loginUser(UserAccountDto userAccountDto);

}
