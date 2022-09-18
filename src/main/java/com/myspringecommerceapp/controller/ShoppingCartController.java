package com.myspringecommerceapp.controller;

import com.myspringecommerceapp.model.ProductInShoppingCart;
import com.myspringecommerceapp.modelDTO.ProductInShoppingCartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingCartController  {


    @GetMapping("/shoppingCart")
    public String viewShoppingCart(){
        return "shoppingCartShow";
    }

    @PostMapping("/add")
    public String addProductToCart(ProductInShoppingCartDTO productInShoppingCartDTO){


        return null;
    }

}
