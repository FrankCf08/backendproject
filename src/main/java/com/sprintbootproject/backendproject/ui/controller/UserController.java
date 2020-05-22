package com.sprintbootproject.backendproject.ui.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
 
 Map <String, UserRest> users;

 @GetMapping
 public String getUsers(@RequestParam(value = "page", defaultValue ="25") int page, 
  @RequestParam(value = "limit", defaultValue = "25") int limit,
  @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){
  return "Get users with params was called with page= " + page + ", limit= "+ limit + " and sort= " + sort;
 }

 @GetMapping(path="/{userID}" ,
  produces = { 
   MediaType.APPLICATION_JSON_VALUE, 
   MediaType.APPLICATION_XML_VALUE 
  })
 public ResponseEntity <UserRest> getUser(@PathVariable String userID){
  
  if(users.containsKey(userID)){

   return new ResponseEntity<UserRest>( users.get(userID), HttpStatus.OK);
  }else{
   
   return new ResponseEntity<UserRest>( HttpStatus.NO_CONTENT);
  }

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

  /* Create a Universal Unique Identifier */
  String userID = UUID.randomUUID().toString();

  /* Save it into my user Object */
  user.setUserID(userID);

  /* Check if it is empthy */
  if(users == null) users = new HashMap<>();

  /* Adding it to my users Map */
  users.put(userID, user);

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