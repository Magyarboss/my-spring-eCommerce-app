package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.mappers.UserToUserDTO;
import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.repositories.UserRepository;
import com.myspringecommerceapp.services.UserService;
import com.myspringecommerceapp.services.UserServiceImpl;
import org.springframework.stereotype.Component;


/**
 * Mozda staviti ovo kao Service???
 */

@Component
public class UserTransporter {

    private final UserRepository userRepository;
    private final UserToUserDTO userToUserDTO;

    public UserTransporter(UserRepository userRepository, UserToUserDTO userToUserDTO) {
        this.userRepository = userRepository;
        this.userToUserDTO = userToUserDTO;
    }

    private static boolean userAvailable = false;
    private static UserDTO userDTO;

    public static boolean isUserAvailable() {
        return userAvailable;
    }
    public UserDTO updateUserDTO(){

        if(UserTransporter.userDTO != null) {
            if (UserTransporter.userDTO.equals( userToUserDTO.convert(userRepository.findUserByUsername(userDTO.getUsername())) )) {
                return userDTO;
            } else {
                return UserTransporter.userDTO = userToUserDTO.convert(userRepository.findUserByUsername(userDTO.getUsername()));
            }
        }
        return null;
    }

    public static void setUser(UserDTO userDTO) {
        UserTransporter.userDTO = userDTO;
        userAvailable = true;
    }

    public UserDTO getUser() {
//        userAvailable = false;
        updateUserDTO();
        return userDTO;
    }
    public static void deleteUserFromSession(){
        UserTransporter.userDTO = null;
        userAvailable = false;
    }
}