package com.sprintbootproject.backendproject.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

 @NotNull (message = "Name cannot be null")
 @Size(min = 2, max = 32, message = "Name cannot be less than 2 characters")
 private String name;

 @NotNull (message = "Lastname cannot be null")
 @Size(min = 2, max = 16, message = "Lastname must be greater than 2 characters")
 private String lastname;

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

}