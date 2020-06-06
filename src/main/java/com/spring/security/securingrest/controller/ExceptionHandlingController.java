package com.spring.security.securingrest.controller;

import com.spring.security.securingrest.model.ErrorDto;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ControllerAdvice
public class ExceptionHandlingController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    public ResponseEntity<ErrorDto>  handleAccessDeniedException(AccessDeniedException ex) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorDto.builder()
                .status(HttpStatus.FORBIDDEN.toString())
                 .errorMessage("Operation Not allowed for this user")
                .description(ex.getMessage()).build());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleDataAccessException(DataAccessException ex) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorDto.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .errorMessage("Internal exception occurred")
                        .description(ex.getMessage()).build());
    }
}
