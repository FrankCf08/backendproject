package com.sprintbootproject.backendproject.ui.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
 
 @GetMapping
 public String getUsers(@RequestParam(value = "page", defaultValue ="25") int page, 
  @RequestParam(value = "limit", defaultValue = "25") int limit,
  @RequestParam(value = "sort", required = false) String sort){
  return "Get users with params was called with page= " + page + ", limit= "+ limit + " and sort= " + sort;
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