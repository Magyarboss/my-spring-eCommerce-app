package com.myspringecommerceapp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Subcategory extends BaseEntity{

    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Subcategory(Long id, String name, Category category) {
        super(id);
        this.name = name;
        this.category = category;
    }
}
