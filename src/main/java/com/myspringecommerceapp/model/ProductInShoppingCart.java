package com.myspringecommerceapp.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProductInShoppingCart extends BaseEntity{

    @OneToOne//(cascade = C)                                  //ili bolje staviti @ManyToOne ???
    @JoinColumn(name = "product_id")                        //mozda dodati bidirectional kod producta da mozemo staviti CascadeType.ALL ako obrisemo proizvod da se obrise i proizvodukosarici
    private Product product;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;              //da li je potrebno bidirectional ovdje?

}
