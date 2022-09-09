package com.myspringecommerceapp.modelDTO;

import com.myspringecommerceapp.model.ProductInShoppingCart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {

    private Long id;
    @NotBlank
    private UserDTO user;
    private List<ProductInShoppingCartDTO> productInShoppingCartList;

}
