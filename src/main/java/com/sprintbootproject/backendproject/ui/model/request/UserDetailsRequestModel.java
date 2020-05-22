package com.sprintbootproject.backendproject.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
 
 @NotNull(message = "Name cannot be empty")
 @Size(min = 8,max = 16, message = "Name cannot be less than 8 or greater than 16 characters") //Size only works with Strings
 private String name;
 
 @NotNull(message = "Lastname cannot be empty")
 private String lastname;

 @NotNull(message = "Email cannot be empty")
 @Email
 private String email;

 @NotNull(message = "Password cannot be empty")
 @Size(min = 8,max = 16, message = "Name cannot be less than 8 or greater than 16 characters") //Size only works with Strings
 private String password;
 
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getLastname() {
  return lastname;
 }
 public void setLastname(String lastname) {
  this.lastname = lastname;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }

}