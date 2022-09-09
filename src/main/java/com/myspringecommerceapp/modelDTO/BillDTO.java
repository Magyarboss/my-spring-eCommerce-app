package com.myspringecommerceapp.modelDTO;

import com.myspringecommerceapp.model.PaymentMethod;
import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.model.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.xml.crypto.Data;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class BillDTO {

    private Long id;
    @NotBlank
    private UserDTO user;
    private ShoppingCartDTO shoppingCart;
    @NotBlank
    @PastOrPresent
    private Date date;
    @NotBlank
    private PaymentMethod paymentMethod;

}
