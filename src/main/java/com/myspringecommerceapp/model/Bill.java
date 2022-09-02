package com.myspringecommerceapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bill extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
//    private Map<Double, Product> productMap or List<Product> products;
    @OneToOne
    private ShoppingCart shoppingCart;
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;

}
