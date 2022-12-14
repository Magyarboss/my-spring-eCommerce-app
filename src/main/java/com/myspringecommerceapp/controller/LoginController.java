package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute
    public void getUser(Model model, HttpServletRequest request){

        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));

    }


    @GetMapping
    public String getLoginForm(Model model){
        //testing if there is already logged-in user and redirect to home page if there is
        if(UserTransporter.isUserAvailable()) {
            return "redirect:/";
        }
//        model.addAttribute("user", User.builder().build());
        return "loginForm";
    }


    @PostMapping
    private String processLoginForm(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request){

        // TODO check if username and password are correct bla bla bla if not show some error if yes redirect:
        UserDTO userDTO = userService.findUserByUsernameAndPassword(username, password );
        model.addAttribute("userDTO", userDTO);
        UserTransporter.setUser(userDTO);

        //testing if history of requests has at least 1 request in history then just redirect to home page..
        // (so it breaks the loop of going back to login.jsp)
        if(ControllerMethods.pageHistory.size() < 2) {
            return ControllerMethods.getPreviousPageByRequestAndRedirect(request).orElse("/");
        }

        return ControllerMethods.pageHistory.get(ControllerMethods.pageHistory.size()-2);
    }

//    @PostMapping
//    private String processLoginForm(@ModelAttribute UserDTO userDTO, BindingResult result, Model model){
//
//        // TODO check if username and password are correct bla bla bla if not show some error if yes redirect:
//        UserDTO userDTO2 = userService.findUserByUsernameAndPassword(userDTO.getUsername(), user );
//
//        if(userDTO.isEmpty()){
//            result
//        }
//
//        return "redirect:/";
//    }



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
