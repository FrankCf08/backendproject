package com.sprintbootproject.backendproject.userService;

import com.sprintbootproject.backendproject.ui.model.request.UserDetailsRequestModel;
import com.sprintbootproject.backendproject.ui.model.response.UserRest;

public interface UserService {
 UserRest createUser(UserDetailsRequestModel userdetails);
}