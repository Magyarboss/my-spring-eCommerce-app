package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.exceptions.NotFoundException;
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

    @GetMapping
    public String getIndexPage(Model model){

        model.addAttribute("categories",categoryService.getCategories() );
        model.addAttribute("products",productService.getProducts());
        return "index";
    }

    @RequestMapping("/category/{categoryId}")
    public String getCategoryProducts(@PathVariable Long categoryId, Model model){

        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("products", productService.findByCategoryId(categoryId));
        model.addAttribute("categoryAtr", categoryService.findById(categoryId));

        return "index";
    }

    @RequestMapping("/category/{categoryId}/subcategory/{subcategoryId}")
    public String getSubcategoryProducts(@PathVariable Long categoryId, @PathVariable Long subcategoryId, Model model){

        model.addAttribute("categoryAtr", categoryService.findById(categoryId));
        model.addAttribute("subcategory", subcategoryService.findById(subcategoryId));
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("products", productService.findBySubcategoryId(subcategoryId));

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
