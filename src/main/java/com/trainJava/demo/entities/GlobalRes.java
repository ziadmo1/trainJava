package com.trainJava.demo.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
public class GlobalRes<T> {

    private final String status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    public GlobalRes(T data) {
        this.message = null;
        this.status = "Success";
        this.data = data;
    }

    public GlobalRes(String error) {
        this.message = error;
        this.status = "Failed";
        this.data = null;
    }

    public GlobalRes(String message, T data) {
        this.message = message;
        this.status = "Success";
        this.data = data;
    }

}
