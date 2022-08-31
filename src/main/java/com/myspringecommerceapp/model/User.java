package com.myspringecommerceapp.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @Builder
    public User(Long id, String firstName, String lastName, String username
            , String password, String email, Byte[] image, UserType userType) {
        super(id, firstName, lastName);
        this.username = username;
        this.password = password;
        this.email = email;
        this.image = image;
        this.userType = userType;
    }
}
