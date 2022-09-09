package com.myspringecommerceapp.modelDTO;

import com.myspringecommerceapp.model.Bill;
import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.model.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")       // at least 8 char, 1 lowercase 1 uppercase 1 number
    private String password;
    @Email
    private String email;
    private Byte[] image;
    @NotBlank
    private UserType userType;

    private ShoppingCart shoppingCart;
    private List<Bill> bills;

}
