package com.trainJava.demo.abstracts;

import com.trainJava.demo.dtos.ForgotPassDto;
import com.trainJava.demo.entities.ForgotPass;

public interface ForgotPassService {

    public ForgotPass processForgotPassword(ForgotPassDto forgotPassDto);

}
