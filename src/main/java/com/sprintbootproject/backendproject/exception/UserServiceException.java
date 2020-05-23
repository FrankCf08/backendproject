package com.sprintbootproject.backendproject.exception;

public class UserServiceException extends RuntimeException {
 
 /**
	 *
	 */
	private static final long serialVersionUID = 5277286029462882644L;

public UserServiceException (String message){
  super(message);
 }
}