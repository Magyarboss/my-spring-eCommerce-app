package com.myspringecommerceapp.mappers;


import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Subcategory;
import com.myspringecommerceapp.modelDTO.CategoryDTO;
import com.myspringecommerceapp.modelDTO.SubcategoryDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDTO, Category> {

    private final SubcategoryDtoToSubcategory subcategoryDtoToSubcategory;

    public CategoryDtoToCategory(SubcategoryDtoToSubcategory subcategoryDtoToSubcategory) {
        this.subcategoryDtoToSubcategory = subcategoryDtoToSubcategory;
    }

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryDTO source) {

        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());

        if(source.getSubcategoriesDTO() != null && source.getSubcategoriesDTO().size() > 0){
            source.getSubcategoriesDTO()
                    .forEach(subcategoryDTO -> category.getSubcategories().add(subcategoryDtoToSubcategory.convert(subcategoryDTO)));
        }
//        else if(source.getSubcategoriesDTO() == null) {
//            category.getSubcategories().add(new Subcategory());
//        }

        return category;

    }
}
