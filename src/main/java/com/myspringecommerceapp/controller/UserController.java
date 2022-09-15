package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.services.ImageService;
import com.myspringecommerceapp.services.UserService;
import com.myspringecommerceapp.services.UserServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/user/{username}")
public class UserController {


    private final UserService userService;
    private final ImageService imageService;
    private final UserTransporter userTransporter;

    public UserController(UserService userService, ImageService imageService, UserTransporter userTransporter) {
        this.userService = userService;
        this.imageService = imageService;
        this.userTransporter = userTransporter;
    }

    @ModelAttribute
    public void getUser(Model model, HttpServletRequest request){

        UserDTO userDTO;
        if(UserTransporter.isUserAvailable()) userDTO = userTransporter.getUser();
        else  userDTO = null;
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));
    }

    @GetMapping("/profile")
    public String getUserProfile(){
        return "userProfile";
    }


    @PostMapping("/image")
    public String processImageForm(@PathVariable String username, @RequestParam MultipartFile file,
                                   HttpServletRequest request){
        imageService.saveImageFile(username, file);
//        UserTransporter.setUser(userService.findUserByUsername(username)); nije vise potrebno jer u UserTransporter.getUser
//                                       radimo i update() pa ga ne moramo stalno iznova postavljat kada dodje do promjene


        return "redirect:/user/" + username + "/profile";
    }


    @GetMapping("/userImage")
    public void renderImageFromDB(@PathVariable String username, HttpServletResponse response, Model model) throws IOException {

        UserDTO userDTO = userService.findUserByUsername(username);             //    (UserDTO) model.getAttribute("userDTO");
        System.out.println("----------------------------Testing usreDTO = " + userDTO);

        if (userDTO.getImage() != null) {
            byte[] byteArray = new byte[userDTO.getImage().length];
            int i = 0;

            for (Byte wrappedByte : userDTO.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    // TODO vjerovatno ne radi jer prvo moram dodati sliku i convertati je u bytove i tako spremiti u bazu i
    //  onda ce raditi kada je converta nazad. ili probati po starom projektu...


}
