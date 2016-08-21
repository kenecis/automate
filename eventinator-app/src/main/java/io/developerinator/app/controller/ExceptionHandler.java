package io.developerinator.app.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.developerinator.app.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@EnableWebMvc
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({
            NullPointerException.class
    })
    public HttpEntity<ErrorResponseDto> handInterServerError(){

        return new ResponseEntity<ErrorResponseDto>(new ErrorResponseDto("Internal Server Error Occurred.")
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
