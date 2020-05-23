package com.sprintbootproject.backendproject.exception;

import java.util.Date;

import com.sprintbootproject.backendproject.ui.model.response.ErrorMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionsHanlder {
 
 /* General Exception catcher */
 @ExceptionHandler(value = {Exception.class})
 public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){

  String errorDescription = e.getLocalizedMessage();
  
  if(errorDescription == null) errorDescription = e.toString();

  ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);


  return new ResponseEntity<>(
    errorMessage, 
    new HttpHeaders(),
    HttpStatus.INTERNAL_SERVER_ERROR);
 }

 /* Creating a method which caches one or more Exceptions: NullPointerException, UserServiceException */
 @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
 public ResponseEntity<Object> handleSpecificExceptions(Exception e, WebRequest request){

  String errorDescription = e.getLocalizedMessage();
  
  if(errorDescription == null) errorDescription = e.toString();

  ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);


  return new ResponseEntity<>(
    errorMessage, 
    new HttpHeaders(),
    HttpStatus.INTERNAL_SERVER_ERROR);
 }

}