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
    private String processLogout(){

        UserTransporter.deleteUserFromSession();

        return "redirect:/";           //ControllerMethods.getPreviousPageByRequestAndRedirect(request).orElse("/"); ovo je ako se zelimo vratiti na proslju stranicu
    }                                                               // ali nije recomended jer se odjavljujemo i imat cemo razlicitih errora

}
