package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.modelDTO.ShoppingCartDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartToShoppingCartDTO implements Converter<ShoppingCart, ShoppingCartDTO> {

    private final UserToUserDTO userToUserDTO;
    private final ProductInShoppingCartToProdInShoppCartDTO productInShoppingCartToProdInShoppCartDTO;

    public ShoppingCartToShoppingCartDTO(UserToUserDTO userToUserDTO, ProductInShoppingCartToProdInShoppCartDTO productInShoppingCartToProdInShoppCartDTO) {
        this.userToUserDTO = userToUserDTO;
        this.productInShoppingCartToProdInShoppCartDTO = productInShoppingCartToProdInShoppCartDTO;
    }


    @Synchronized
    @Nullable
    @Override
    public ShoppingCartDTO convert(ShoppingCart source) {

        if(source == null) return null;

        final ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

        shoppingCartDTO.setId(source.getId());
        shoppingCartDTO.setUser(userToUserDTO.convert(source.getUser()));

        if(source.getProductInShoppingCartList() != null && source.getProductInShoppingCartList().size() > 0){
            source.getProductInShoppingCartList().forEach(productInShoppingCart -> {
                shoppingCartDTO.getProductInShoppingCartList().add(productInShoppingCartToProdInShoppCartDTO.convert(productInShoppingCart));
            });
        }

        return shoppingCartDTO;
    }
}
