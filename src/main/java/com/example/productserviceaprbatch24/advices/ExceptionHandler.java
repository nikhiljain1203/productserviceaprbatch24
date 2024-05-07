package com.example.productserviceaprbatch24.advices;

import com.example.productserviceaprbatch24.controllers.ProductController;
import com.example.productserviceaprbatch24.dtos.ExceptionDto;
import com.example.productserviceaprbatch24.exceptions.ProductLimitReachedExpection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException() {
        System.out.println("Something went Wrong");
        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedExpection.class)
    public ResponseEntity<ExceptionDto> handleCustomException() {
        System.out.println("Something went Wrong");
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        exceptionDto.setMessage("Custom Exception Handling");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
