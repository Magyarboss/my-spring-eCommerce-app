package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {              //prebaciti mozda na CategoryDTO
        log.debug("Loading all categories - CategoryServiceImpl");
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
//        for(Category c : categories) System.out.println(c.getName());
//        for(Category c : categories) System.out.println("Category subcategories = " + c.getSubcategories().toString());
        return categories;
    }

    @Override
    public Category findById(Long l) {
        Optional<Category> categoryOptional = categoryRepository.findById(l);
        if(categoryOptional.isEmpty()){
            throw new NotFoundException("Category Not Found. For ID value: " + l );
        }

        return  categoryOptional.get();
    }

    @Override
    public Category findByName(String name) {

        return null;
    }
}
