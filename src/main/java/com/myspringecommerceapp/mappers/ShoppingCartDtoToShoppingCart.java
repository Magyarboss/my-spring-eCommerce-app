package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.modelDTO.ShoppingCartDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoToShoppingCart implements Converter<ShoppingCartDTO, ShoppingCart> {

    private final UserDtoToUser userDtoToUser;
    private final ProductInShoppingCartDtoToProdInShoppCart productInShoppingCartDtoToProdInShoppCart;

    public ShoppingCartDtoToShoppingCart(UserDtoToUser userDtoToUser, ProductInShoppingCartDtoToProdInShoppCart productInShoppingCartDtoToProdInShoppCart) {
        this.userDtoToUser = userDtoToUser;
        this.productInShoppingCartDtoToProdInShoppCart = productInShoppingCartDtoToProdInShoppCart;
    }

    @Synchronized
    @Nullable
    @Override
    public ShoppingCart convert(ShoppingCartDTO source) {

        if(source == null) return null;

        final ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setId(source.getId());
        shoppingCart.setUser(userDtoToUser.convert(source.getUser()));

        if(source.getProductInShoppingCartList() != null && source.getProductInShoppingCartList().size() > 0 ){
            source.getProductInShoppingCartList().forEach(productInShoppingCartDTO -> {
                shoppingCart.getProductInShoppingCartList().add(productInShoppingCartDtoToProdInShoppCart.convert(productInShoppingCartDTO));
            });
        }

        return shoppingCart;
    }
}
