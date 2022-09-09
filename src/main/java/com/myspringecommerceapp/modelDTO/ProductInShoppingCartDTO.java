package com.myspringecommerceapp.modelDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductInShoppingCartDTO {

    private Long id;
    private ProductDTO product;
    private int quantity;
    private ShoppingCartDTO shoppingCart;

}
