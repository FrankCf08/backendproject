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

 /* Creating an specific method catcher for my Exception: NullPointerException */
 @ExceptionHandler(value = {NullPointerException.class})
 public ResponseEntity<Object> handleNullPointerException(NullPointerException e, WebRequest request){

  String errorDescription = e.getLocalizedMessage();
  
  if(errorDescription == null) errorDescription = e.toString();

  ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);


  return new ResponseEntity<>(
    errorMessage, 
    new HttpHeaders(),
    HttpStatus.INTERNAL_SERVER_ERROR);
 }

  /* Creating a UserServiceException Exception */
 @ExceptionHandler(value = {UserServiceException.class})
 public ResponseEntity<Object> handleUserServiceException(UserServiceException e, WebRequest request){

  String errorDescription = e.getLocalizedMessage();
  
  if(errorDescription == null) errorDescription = e.toString();

  ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);


  return new ResponseEntity<>(
    errorMessage, 
    new HttpHeaders(),
    HttpStatus.INTERNAL_SERVER_ERROR);
 }
}