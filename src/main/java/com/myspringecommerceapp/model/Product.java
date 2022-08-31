package com.myspringecommerceapp.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
    private Byte[] image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @Nullable
    private Subcategory subcategory;

    @Builder
    public Product(Long id, String name, String description, int quantityInStock
                        , Double price, Byte[] image, Category category, Subcategory subcategory) {
        super(id);
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.image = image;
        this.category = category;
        this.subcategory = subcategory;
    }
}
