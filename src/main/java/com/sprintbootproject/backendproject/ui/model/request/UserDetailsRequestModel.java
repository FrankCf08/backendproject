package com.sprintbootproject.backendproject.ui.model.request;

public class UserDetailsRequestModel {
 
 private String name;
 private String lastname;
 private String email;
 private int password;
 
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
 public int getPassword() {
  return password;
 }
 public void setPassword(int password) {
  this.password = password;
 }

}