package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {

    private final BillDtoToBill billDtoToBill;
    private final ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart;

    public UserDtoToUser(BillDtoToBill billDtoToBill, ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart) {
        this.billDtoToBill = billDtoToBill;
        this.shoppingCartDtoToShoppingCart = shoppingCartDtoToShoppingCart;
    }

    @Synchronized
    @Nullable
    @Override
    public User convert(UserDTO source) {
        if(source  == null) return null;

        final User user = new User();

        user.setId(source.getId());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setEmail(source.getEmail());
        user.setImage(source.getImage());
        user.setUserType(source.getUserType());
        user.setShoppingCart(shoppingCartDtoToShoppingCart.convert(source.getShoppingCart()));

        if(source.getBills() != null && source.getBills().size() > 0){
            source.getBills().forEach(billDTO -> {
                user.getBills().add(billDtoToBill.convert(billDTO));
            });
        }

        return user;
    }
}
