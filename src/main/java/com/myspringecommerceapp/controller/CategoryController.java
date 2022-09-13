package com.myspringecommerceapp.controller;


import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.services.CategoryService;
import com.myspringecommerceapp.services.ProductService;
import com.myspringecommerceapp.services.SubcategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping({"/category"})
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SubcategoryService subcategoryService;

    public CategoryController(CategoryService categoryService, ProductService productService, SubcategoryService subcategoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.subcategoryService = subcategoryService;
    }


    @ModelAttribute
    public void getUser(Model model, HttpServletRequest request){

        UserDTO userDTO;
        if(UserTransporter.isUserAvailable()) userDTO = UserTransporter.getUser();
        else  userDTO = null;

//        if(userDTO == null) System.out.println("Category Cont &&&&&&&&&&&&&&&&&&&&&&&&& userDTO IS NULL");
//        else System.out.println(" Category Cont &&&&&&&&& it is not null user is: " + userDTO);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));
        System.out.println("Category Controler!!!!!!!!!!!!!!!!!!!!!!");
    }




    @RequestMapping("/{categoryId}")
    public String getCategoryProducts(@PathVariable Long categoryId, Model model, @RequestParam(defaultValue = "nameASC") String orderBy){

        List<ProductDTO> productDTOList = productService.findByCategoryId(categoryId);

        // ---- Sortirana lista proizvoda ----
        productDTOList = productService.sortProductDTOListBy(productDTOList, orderBy);

        model.addAttribute("orderBy", orderBy);
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("products", productDTOList);
        model.addAttribute("categoryAtr", categoryService.findById(categoryId));

        return "index";
    }
//    @RequestMapping("/{orderBy}")
//    public String sortBy(@PathVariable String orderBy, Model model){
//
//        model.addAttribute("categories",categoryService.getCategories());
////        model.addAttribute("products", productService.findByCategoryId(categoryId));
////        model.addAttribute("categoryAtr", categoryService.findById(categoryId));
//
//        return "redirect:/category/{categoryId}";
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
