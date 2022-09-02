package com.myspringecommerceapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCart extends BaseEntity{

    @OneToOne
    private User user;
    @OneToMany(mappedBy = "shoppingCart")
    private Set<ProductInShoppingCart> productInShoppingCartList;

}
