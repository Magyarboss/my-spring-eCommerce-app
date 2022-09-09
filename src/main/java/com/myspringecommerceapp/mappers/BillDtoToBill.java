package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Bill;
import com.myspringecommerceapp.modelDTO.BillDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BillDtoToBill implements Converter<BillDTO, Bill> {

    private final UserDtoToUser userDtoToUser;
    private final ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart;

    public BillDtoToBill(UserDtoToUser userDtoToUser, ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart) {
        this.userDtoToUser = userDtoToUser;
        this.shoppingCartDtoToShoppingCart = shoppingCartDtoToShoppingCart;
    }

    @Synchronized
    @Nullable
    @Override
    public Bill convert(BillDTO source) {
        if(source== null) return null;

        final Bill bill = new Bill();

        bill.setId(source.getId());
        bill.setUser(userDtoToUser.convert(source.getUser()));
        bill.setShoppingCart(shoppingCartDtoToShoppingCart.convert(source.getShoppingCart()));
        bill.setDate(source.getDate());
        bill.setPaymentMethod(source.getPaymentMethod());

        return bill;
    }
}
