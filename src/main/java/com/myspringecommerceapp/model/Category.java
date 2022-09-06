package com.myspringecommerceapp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    @Builder
    public Category(Long id, String name, List<Subcategory> subcategories) {
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
