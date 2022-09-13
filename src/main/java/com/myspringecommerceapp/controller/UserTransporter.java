package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.modelDTO.UserDTO;

public class UserTransporter {

    private static boolean userAvailable = false;
    private static UserDTO userDTO;

    public static boolean isUserAvailable() {
        return userAvailable;
    }

    public static void setUser(UserDTO userDTO) {
        UserTransporter.userDTO = userDTO;
        userAvailable = true;
    }

    public static UserDTO getUser() {
//        userAvailable = false;
        return userDTO;
    }
    public static void deleteUserFromSession(){
        UserTransporter.userDTO = null;
        userAvailable = false;
    }
}