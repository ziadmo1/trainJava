package com.trainJava.demo.shared;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.trainJava.demo.entities.GlobalRes;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GlobalRes<?>> handleNoResourceFoundException(NoResourceFoundException e) {
        return ResponseEntity.status(404).body(new GlobalRes<>(e.getMessage()));
    }

    @ExceptionHandler(CustomResponseExc.class)
    public ResponseEntity<GlobalRes<?>> handleCustomResponseException(CustomResponseExc e) {
        return ResponseEntity.status(e.getCode()).body(new GlobalRes<>(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalRes<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(new GlobalRes<>(e.getFieldError().getDefaultMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GlobalRes<?>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(400).body(new GlobalRes<>(e.getRootCause().getMessage()));
    }

}
