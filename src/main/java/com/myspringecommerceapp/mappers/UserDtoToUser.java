package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {

//    private final BillDtoToBill billDtoToBill;
//    private final ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart;
//
//
//    public UserDtoToUser(BillDtoToBill billDtoToBill) {
//        this.billDtoToBill = billDtoToBill;
//    }

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

        if(source.getShoppingCartId() != null){
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setId(source.getShoppingCartId());
            user.setShoppingCart(shoppingCart);
            shoppingCart.setUser(user);
        }

//        if(source.getBills() != null && source.getBills().size() > 0){
//            source.getBills().forEach(billDTO -> {
//                user.getBills().add(billDtoToBill.convert(billDTO));
//            });
//        }

        return user;
    }
}
