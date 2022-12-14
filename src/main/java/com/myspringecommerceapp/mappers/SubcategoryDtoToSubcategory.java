package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Subcategory;
import com.myspringecommerceapp.modelDTO.SubcategoryDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryDtoToSubcategory implements Converter<SubcategoryDTO, Subcategory> {


    @Synchronized
    @Nullable
    @Override
    public Subcategory convert(SubcategoryDTO source) {

        if (source == null) {
            return null;
        }

        final Subcategory subcategory = new Subcategory();
        subcategory.setId(source.getId());
        subcategory.setName(source.getName());

        if(source.getCategoryId() != null){
            Category category = new Category();
            category.setId(source.getCategoryId());
            subcategory.setCategory(category);
            category.addSubcategory(subcategory); //dodajemo da i categorija zna za subcategory - testirati mozda kako bi radilo bez toga
        }

        return subcategory;
    }
}
