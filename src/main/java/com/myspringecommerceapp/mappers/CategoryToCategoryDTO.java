package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.modelDTO.CategoryDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTO implements Converter<Category, CategoryDTO> {

    private final SubcategoryToSubcategoryDTO subcategoryToSubcategoryDTO;

    public CategoryToCategoryDTO(SubcategoryToSubcategoryDTO subcategoryToSubcategoryDTO) {
        this.subcategoryToSubcategoryDTO = subcategoryToSubcategoryDTO;
    }

    @Synchronized
    @Nullable
    @Override
    public CategoryDTO convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(source.getId());
        categoryDTO.setName(source.getName());

        if(source.getSubcategories() != null && source.getSubcategories().size() > 0){
            source.getSubcategories()
                    .forEach(subcategory -> categoryDTO.getSubcategoriesDTO().add(subcategoryToSubcategoryDTO.convert(subcategory)));
        }
        return categoryDTO;
    }
}
