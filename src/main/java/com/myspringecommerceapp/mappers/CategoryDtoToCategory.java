package com.myspringecommerceapp.mappers;


import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.modelDTO.CategoryDTO;
import com.myspringecommerceapp.modelDTO.SubcategoryDTO;
import org.springframework.core.convert.converter.Converter;

public class CategoryDtoToCategory implements Converter<CategoryDTO, Category> {

    private final SubcategoryDtoToSubcategory subcategoryDtoToSubcategory;

    public CategoryDtoToCategory(SubcategoryDtoToSubcategory subcategoryDtoToSubcategory) {
        this.subcategoryDtoToSubcategory = subcategoryDtoToSubcategory;
    }

    @Override
    public Category convert(CategoryDTO source) {

        if (source == null) {
            return null;
        }

        Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());

        if(source.getSubcategoriesDTO() != null && source.getSubcategoriesDTO().size() > 0){
            source.getSubcategoriesDTO()
                    .forEach(subcategoryDTO -> category.getSubcategories().add(subcategoryDtoToSubcategory.convert(subcategoryDTO)));
        }

        return category;

    }
}
