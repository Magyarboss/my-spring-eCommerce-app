package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.User;
import com.myspringecommerceapp.modelDTO.UserDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

    private final BillToBillDTO billToBillDTO;


    @Synchronized
    @Nullable
    @Override
    public UserDTO convert(User source) {

        if(source == null){
            return null;
        }

        final UserDTO userDTO = new UserDTO();

        userDTO.setId(source.getId());
        userDTO.setFirstName(source.getFirstName());
        userDTO.setLastName(source.getLastName());
        userDTO.setUsername(source.getUsername());
        userDTO.setPassword(source.getPassword());
        userDTO.setEmail(source.getEmail());
        userDTO.setImage(source.getImage());
        userDTO.setUserType(source.getUserType());
        userDTO.setShoppingCart(source.getShoppingCart());

        if(source.getBills() != null && source.getBills().size() > 0){
            source.getBills().forEach(bill -> {
                userDTO.getBills().add(billToBillDTO.convert(bill));
            });
        }

        return userDTO;
    }
}
