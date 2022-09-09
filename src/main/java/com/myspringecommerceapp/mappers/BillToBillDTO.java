package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Bill;
import com.myspringecommerceapp.modelDTO.BillDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BillToBillDTO implements Converter<Bill, BillDTO> {

    private final UserToUserDTO userToUserDTO;
    private final ShoppingCartToShoppingCartDTO shoppingCartToShoppingCartDTO;

    public BillToBillDTO(UserToUserDTO userToUserDTO, ShoppingCartToShoppingCartDTO shoppingCartToShoppingCartDTO) {
        this.userToUserDTO = userToUserDTO;
        this.shoppingCartToShoppingCartDTO = shoppingCartToShoppingCartDTO;
    }

    @Synchronized
    @Nullable
    @Override
    public BillDTO convert(Bill source) {
        if(source== null) return null;

        final BillDTO billDTO = new BillDTO();

        billDTO.setId(source.getId());
        billDTO.setUser(userToUserDTO.convert(source.getUser()));
        billDTO.setShoppingCart(shoppingCartToShoppingCartDTO.convert(source.getShoppingCart()));
        billDTO.setDate(source.getDate());
        billDTO.setPaymentMethod(source.getPaymentMethod());

        return billDTO;
    }
}
