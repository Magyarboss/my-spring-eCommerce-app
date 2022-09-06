package com.myspringecommerceapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testController {

    @RequestMapping("/index")
    public String testHome(Model model){
        model.addAttribute("testMessage", "Hello from test controller");
        return "test";
    }
}
