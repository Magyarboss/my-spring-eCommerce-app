package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.modelDTO.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


//    @ModelAttribute
//    public void getUser(Model model, HttpServletRequest request){
//
//        UserDTO userDTO;
//        if(UserTransporter.isUserAvailable()) userDTO = UserTransporter.getUser();
//        else  userDTO = null;
//
//        model.addAttribute("userDTO", userDTO);
//        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));
//    }

    @GetMapping
    public String getRegistrationForm(){
        return "registrationForm";
    }


    @PostMapping
    public String processRegistrationForm(){

        return "registrationForm";
    }

}
