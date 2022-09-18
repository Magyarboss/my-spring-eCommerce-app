package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

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
    @InitBinder
    public void setDesallowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("userType");
    }

    @GetMapping
    public String getRegistrationForm(){
//        model.addAttribute(request.getAttribute("usernameExists"));
//        model.getAttribute("usernameExists");

//        model.addAttribute("usernameExists", usernameExists);
        return "registrationForm";
    }


    @PostMapping
    public String processRegistrationForm(@Validated @ModelAttribute UserDTO userDTO,
                                                @RequestParam String passwordCheck, BindingResult result
                                                , RedirectAttributes redirectAttributes){

        System.out.println("***************** TESTING USERDTO: " + userDTO.getUserType());
        // TODO otkriti kako prikazati ove errore (kako ih prenjeti na view)
        //  izgleda da treba koristiti <form:form i <form:errors> ili druga opcija model.addAttribute("errors", result.getAllErrors()); -- Ne znam sto se desava...
        if(result.hasErrors()){
            System.out.println("*******************************Caught an ERROR");
            result.reject("password", "bad password");
//            result.rejectValue("password", "badPassword", "bad password");
            return "registrationForm";
        }

            //TODO testirati bez cega sve moze raditi da bude minimalno koda..redirectAttributes..
        if(!passwordCheck.equals(userDTO.getPassword())){
//            model.addAttribute("incorrectPassword", "Niste ispravno potvrdili lozinku!");
            redirectAttributes.addFlashAttribute("incorrectPassword", "Niste ispravno potvrdili lozinku!");
            return "redirect:/registration";
        }

        else if(userService.readUserByUsername(userDTO.getUsername())!=null){
//            model.addAttribute("usernameExists", "Korisničko ime " + userDTO.getUsername() + " već postoji");
            redirectAttributes.addFlashAttribute("usernameExists", "Korisničko ime '" + userDTO.getUsername() + "' već postoji");
            return "redirect:/registration";
        }

        else if(userService.readUserByEmail(userDTO.getEmail())!=null){
            redirectAttributes.addFlashAttribute("emailExists", "Email '" + userDTO.getEmail() + "' već postoji");
            return "redirect:/registration";
        }

        UserDTO savedUserDTO = userService.saveUserDTO(userDTO);
        redirectAttributes.addFlashAttribute("successfulRegist", "Uspiješno ste se registrirali!!! Sada se možete prijaviti.");
        System.out.println("***************** User Controler savedUserDTO : "+ savedUserDTO.toString());
        return "redirect:/login";
    }

}
