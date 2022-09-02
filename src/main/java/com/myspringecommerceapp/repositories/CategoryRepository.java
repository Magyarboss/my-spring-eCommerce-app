package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
