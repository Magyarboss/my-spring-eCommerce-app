package com.myspringecommerceapp.controller;


import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {


    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    private String processLoginForm(UserDTO userDTO, Model model, HttpServletRequest request){

        // TODO check if username and password are correct bla bla bla if not show some error if yes redirect:

        System.out.println("------------- Logout controler: userDTO : " + userDTO.toString() + "usertrasport = " + UserTransporter.getUser());
        model.addAttribute("userDTO", userDTO);
        UserTransporter.deleteUserFromSession();
        System.out.println("------------- Logout controler: deleted userDTO : " + userDTO);

        return ControllerMethods.getPreviousPageByRequestAndRedirect(request).orElse("/");
    }

}
