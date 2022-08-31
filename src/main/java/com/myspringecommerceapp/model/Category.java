package com.myspringecommerceapp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Subcategory> subcategories;

    @Builder
    public Category(Long id, String name, Set<Subcategory> subcategories) {
        super(id);
        this.name = name;
        this.subcategories = subcategories;
    }



    public Category addSubcategory(Subcategory subcategory){
        subcategory.setCategory(this);
        this.subcategories.add(subcategory);
        return this;
    }
}
