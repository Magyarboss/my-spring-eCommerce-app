package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;

public interface UserService {

    UserDTO findUserByUsernameAndPassword(String username, String password);

    UserDTO findUserByUsername(String username);

    UserDTO readUserByUsername(String username);

    UserDTO readUserByEmail(String email);

    UserDTO saveUserDTO(UserDTO userDTO);

}
