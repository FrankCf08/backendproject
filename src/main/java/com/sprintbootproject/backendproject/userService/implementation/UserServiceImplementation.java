package com.sprintbootproject.backendproject.userService.implementation;

import java.util.HashMap;
import java.util.UUID;

import com.sprintbootproject.backendproject.ui.model.request.UserDetailsRequestModel;
import com.sprintbootproject.backendproject.ui.model.response.UserRest;
import com.sprintbootproject.backendproject.userService.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

 HashMap <String, UserRest> users;

	@Override
	public UserRest createUser(UserDetailsRequestModel userdetails) {
  
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

		return user;
	}
 
}