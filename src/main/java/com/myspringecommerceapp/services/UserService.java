package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;

public interface UserService {

    UserDTO findUserByUsernameAndPassword(String username, String password);

}
