package com.sprintbootproject.backendproject.ui.controller;


import javax.validation.Valid;

import com.sprintbootproject.backendproject.ui.model.request.UserDetailsRequestModel;
import com.sprintbootproject.backendproject.ui.model.response.UserRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
 
 @GetMapping
 public String getUsers(@RequestParam(value = "page", defaultValue ="25") int page, 
  @RequestParam(value = "limit", defaultValue = "25") int limit,
  @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){
  return "Get users with params was called with page= " + page + ", limit= "+ limit + " and sort= " + sort;
 }

 @GetMapping(path="/{userId}" ,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
 public ResponseEntity <UserRest> getUser(@PathVariable String userId){
  
  UserRest user = new UserRest();
  user.setName("Frank");
  user.setLastname("Cruzf'");
  user.setEmail("test@test.com");

  return new ResponseEntity<UserRest>( user, HttpStatus.OK);
 }

 @PostMapping(
  consumes = {
   MediaType.APPLICATION_XML_VALUE,
   MediaType.APPLICATION_JSON_VALUE
  },
  produces = {
   MediaType.APPLICATION_XML_VALUE,
   MediaType.APPLICATION_JSON_VALUE
  })
 public ResponseEntity <UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userdetails){
  
  UserRest user = new UserRest();
  user.setName(userdetails.getName());
  user.setLastname(userdetails.getLastname());
  user.setEmail(userdetails.getEmail());

  return new ResponseEntity<>(user, HttpStatus.OK);
 }

 @PutMapping
 public String updateUser(){
  return "Update user was called";
 }

 @DeleteMapping
 public String deleteUser(){
  return "Delete user was called";
 }
}