package com.sprintbootproject.backendproject.ui.model.response;

public class UserRest {
 private String name;
 private String lastname;
 private String email;
 private String userID;

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
 public String getUserID() {
  return userID;
 }
 public void setUserID(String userID) {
  this.userID = userID;
 }
 
}