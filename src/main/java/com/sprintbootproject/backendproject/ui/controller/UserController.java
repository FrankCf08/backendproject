package com.sprintbootproject.backendproject.ui.controller;


import java.util.Map;

import javax.validation.Valid;

import com.sprintbootproject.backendproject.ui.model.request.UpdateUserDetailsRequestModel;
import com.sprintbootproject.backendproject.ui.model.request.UserDetailsRequestModel;
import com.sprintbootproject.backendproject.ui.model.response.UserRest;
import com.sprintbootproject.backendproject.userService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

 /*Autowired will create an instance of the UserSerciceImplementation Object
   and make it available for us here */
 @Autowired
 UserService userService;

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

  // if(true) throw new UserServiceException("UserServiceException is being thrown");
  // String name = null;
  // name.length();
  
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
  
  // UserRest user =  new UserServiceImplementation().createUser(userdetails);
  UserRest user = userService.createUser(userdetails);

  return new ResponseEntity<>(user, HttpStatus.OK);
 }

 @PutMapping(
  path = "/{userID}",
  consumes = {
   MediaType.APPLICATION_XML_VALUE,
   MediaType.APPLICATION_JSON_VALUE,
  },
  produces = {
   MediaType.APPLICATION_XML_VALUE,
   MediaType.APPLICATION_JSON_VALUE,
  }
 )
 public ResponseEntity <UserRest> updateUser(
  @PathVariable String userID ,
  @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){

   UserRest storedUsers = users.get(userID);
   storedUsers.setName(userDetails.getName());
   storedUsers.setLastname(userDetails.getLastname());

   users.put(userID, storedUsers);
   
  return new ResponseEntity<UserRest>(users.get(userID),HttpStatus.OK);
 }

 @DeleteMapping(
  path = "/{userID}")
 public ResponseEntity<Void> deleteUser(@PathVariable String userID){

   users.remove(userID);

  return ResponseEntity.noContent().build();
 }
}