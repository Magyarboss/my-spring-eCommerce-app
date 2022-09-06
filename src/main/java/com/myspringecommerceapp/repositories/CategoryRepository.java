package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Subcategory;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByName(String name);

}
