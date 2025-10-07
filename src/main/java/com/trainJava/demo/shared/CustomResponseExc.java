package com.trainJava.demo.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomResponseExc extends RuntimeException {
    private final int code;
    private final String message;

    public static CustomResponseExc errorRes(String message) {
        return new CustomResponseExc(400, message);
    }

    public static CustomResponseExc invalidCredentials(String message) {
        return new CustomResponseExc(401, message);
    }

}
