package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.modelDTO.UserDTO;
import com.myspringecommerceapp.repositories.SubcategoryRepository;
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
import java.util.*;

@Slf4j
@Controller
@RequestMapping({"", "/index", "/index.jsp"})
public class IndexController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SubcategoryService subcategoryService;

    public IndexController(CategoryService categoryService, ProductService productService, SubcategoryService subcategoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.subcategoryService = subcategoryService;
    }

    @ModelAttribute
    public void getUser(Model model, HttpServletRequest request){

        UserDTO userDTO;
        if(UserTransporter.isUserAvailable()) userDTO = UserTransporter.getUser();
        else  userDTO = null;

//        if(userDTO == null) System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& userDTO IS NULL");
//        else System.out.println("&&&&&&&&& it is not null user is: " + userDTO);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("pageHistory", ControllerMethods.addPageToHistory(request));
    }

    @GetMapping
    public String getIndexPage(Model model, @RequestParam(defaultValue = "nameASC") String orderBy){

        List<ProductDTO> productDTOList = productService.getProducts();

        // ---- Sortirana lista proizvoda ----
        productDTOList = productService.sortProductDTOListBy(productDTOList, orderBy);

        model.addAttribute("orderBy", orderBy);
        model.addAttribute("categories", categoryService.getCategories() );
        model.addAttribute("products", productDTOList);
        return "index";
    }


//    @RequestMapping("/category/{categoryId}/subcategory/{subcategoryId}/{orderBy}")
//    public String getProductsOrderBy(@PathVariable Long categoryId, @PathVariable Long subcategoryId, Model model, @PathVariable String orderBy){
//
//        List<ProductDTO> productDTOList = new ArrayList<>();
//
//        if(orderBy.equals("ASC")){
//            productDTOList = productService.findByCategoryIdAndSubcategoryIdOrderByNameAsc(categoryId, subcategoryId);
//        }else if(orderBy.equals("DESC")){
//            productDTOList = productService.findByCategoryIdAndSubcategoryIdOrderByNameDesc(categoryId, subcategoryId);
//        }
//
//        model.addAttribute("subcategoryAtr", subcategoryService.findById(subcategoryId));
//        model.addAttribute("categoryAtr", categoryService.findById(categoryId));
//        model.addAttribute("subcategory", subcategoryService.findById(subcategoryId));
//        model.addAttribute("categories",categoryService.getCategories());
//        model.addAttribute("products", productDTOList);
//
//        return "index";
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
