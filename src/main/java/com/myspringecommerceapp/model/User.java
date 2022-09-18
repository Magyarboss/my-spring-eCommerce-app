package com.myspringecommerceapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")  //izbacuje error ako se tablica zove "user" iz nekog razloga
public class User extends Person{

    private String username;
    private String password;
    private String email;
    @Lob
    private Byte[] image;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bill> bills;


    @Builder
    public User(Long id, String firstName, String lastName, String username, String password, String email, Byte[] image, UserType userType, ShoppingCart shoppingCart, List<Bill> bills) {
        super(id, firstName, lastName);
        this.username = username;
        this.password = password;
        this.email = email;
        this.image = image;
        this.userType = userType;
        this.shoppingCart = shoppingCart;
        this.bills = bills;
    }
}
