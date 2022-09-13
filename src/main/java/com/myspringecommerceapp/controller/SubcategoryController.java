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
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/category/{categoryId}/subcategory")
public class SubcategoryController {


    private final CategoryService categoryService;
    private final ProductService productService;
    private final SubcategoryService subcategoryService;

    public SubcategoryController(CategoryService categoryService, ProductService productService, SubcategoryService subcategoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.subcategoryService = subcategoryService;
    }


    @ModelAttribute
    public void getUser(Model model, HttpServletRequest request){

        UserDTO userDTO;
        if(UserTransporter.isUserAvailable()) userDTO = UserTransporter.getUser();
        else  userDTO = null;

//        if(userDTO == null) System.out.println("Subcat Cont &&&&&&&&&&&&&&&&&&&&&&&&& userDTO IS NULL");
//        else System.out.println(" Subcat Cont &&&&&&&&& it is not null user is: " + userDTO);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));
    }





    @RequestMapping("/{subcategoryId}")
    public String getSubcategoryProducts(@PathVariable Long categoryId, @PathVariable Long subcategoryId, Model model
                                                , @RequestParam(defaultValue = "nameASC") String orderBy){

        List<ProductDTO> productDTOList = productService.findBySubcategoryId(subcategoryId);

        // ---- Sortirana lista proizvoda ----
        productDTOList = productService.sortProductDTOListBy(productDTOList, orderBy);

        model.addAttribute("orderBy", orderBy);
        model.addAttribute("categoryAtr", categoryService.findById(categoryId));
        model.addAttribute("subcategoryAtr", subcategoryService.findById(subcategoryId));
        model.addAttribute("subcategory", subcategoryService.findById(subcategoryId));
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("products", productDTOList);


        return "index";
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
