package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTO implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(Product source) {
        if(source == null) return null;

        final ProductDTO productDTO = new ProductDTO();
        productDTO.setId(source.getId());
        productDTO.setName(source.getName());
        productDTO.setDescription(source.getDescription());
        productDTO.setQuantityInStock(source.getQuantityInStock());
        productDTO.setPrice(source.getPrice());
        productDTO.setImage(source.getImage()); //Da li ce ovo raditi ili treba jos nesto napraviti???

        if(source.getCategory() != null){
            productDTO.setCategoryId(source.getCategory().getId());
        }
        if(source.getSubcategory() != null){
            productDTO.setSubcategoryId(source.getSubcategory().getId());
        }


        return productDTO;
    }
}
