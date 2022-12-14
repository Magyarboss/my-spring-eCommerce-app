package com.myspringecommerceapp.modelDTO;

import com.myspringecommerceapp.model.Bill;
import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.model.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class UserDTO {

    private Long id;
    private Long shoppingCartId;
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
    @Nullable
    private Byte[] image;
    private UserType userType;



}
