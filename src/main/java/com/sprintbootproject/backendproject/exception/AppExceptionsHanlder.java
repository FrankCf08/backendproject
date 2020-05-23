package com.sprintbootproject.backendproject.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionsHanlder {
 
 @ExceptionHandler(value = {Exception.class})
 public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
  return new ResponseEntity<>(
    e, 
    new HttpHeaders(),
    HttpStatus.INTERNAL_SERVER_ERROR);
 }
}