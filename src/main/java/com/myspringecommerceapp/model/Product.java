package com.myspringecommerceapp.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity{

    private String name;
    private String description;
    private int quantityInStock;
    private Double price;
    @Lob
    private String image;
//    private Byte[] image;  TODO put it back to byte[]
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @Nullable
    private Subcategory subcategory;
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductInShoppingCart productInShoppingCart;

    @Builder

    public Product(Long id, String name, String description, int quantityInStock, Double price,
                   String image, Category category, @Nullable Subcategory subcategory,
                   ProductInShoppingCart productInShoppingCart) {
        super(id);
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.image = image;
        this.category = category;
        this.subcategory = subcategory;
        this.productInShoppingCart = productInShoppingCart;
    }
}
