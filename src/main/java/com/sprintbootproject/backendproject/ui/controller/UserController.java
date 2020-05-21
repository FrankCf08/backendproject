package com.sprintbootproject.backendproject.ui.controller;


import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
 
 @GetMapping
 public String getUsers(@PathParam(value = "page") int page, @PathParam(value = "limit") int limit){
  return "Get users with params was called with page= " + page + " and limit= "+ limit;
 }

 @GetMapping(path="/{userId}")
 public String getUser(@PathVariable String userId){
  return "Get user was called with userId= " + userId;
 }

 @PostMapping
 public String createUser(){
  return "Post user was called";
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