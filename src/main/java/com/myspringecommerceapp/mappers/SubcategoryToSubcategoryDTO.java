package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Subcategory;
import com.myspringecommerceapp.modelDTO.SubcategoryDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class SubcategoryToSubcategoryDTO implements Converter<Subcategory, SubcategoryDTO> {

    @Synchronized
    @Nullable
    @Override
    public SubcategoryDTO convert(Subcategory source) {

        if (source == null) {
            return null;
        }

        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setId(source.getId());
        subcategoryDTO.setName(source.getName());

        if(source.getCategory() != null){
            subcategoryDTO.setCategoryId(source.getCategory().getId());
        }

        return subcategoryDTO;
    }

}
