package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> getCategories();

    Category  findById(Long l);

    Category findByName(String name);

}
