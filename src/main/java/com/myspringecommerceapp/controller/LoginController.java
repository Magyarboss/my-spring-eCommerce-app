package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping({"/login"})
    public String loginForm(){

        return "login";
    }

    @PostMapping
    private String processLoginForm(@RequestParam String username, @RequestParam String password){

        // TODO check if username and password are corerect bla bla bla if not show some error if yes redirect:

        return "redirect:/";
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }

}
