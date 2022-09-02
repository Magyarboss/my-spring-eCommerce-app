package com.myspringecommerceapp.mappers;

import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.model.Subcategory;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import org.springframework.core.convert.converter.Converter;

public class ProductDtoToProduct implements Converter<ProductDTO, Product> {

    @Override
    public Product convert(ProductDTO source) {
        if(source == null) return null;

        final Product product = new Product();
        product.setId(source.getId());
        product.setName(source.getName());
        product.setDescription(source.getDescription());
        product.setQuantityInStock(source.getQuantityInStock());
        product.setPrice(source.getPrice());
        product.setImage(source.getImage());

        if(source.getCategoryId() != null){
            Category category = new Category();
            category.setId(source.getCategoryId());
            product.setCategory(category);
        }
        if(source.getSubcategoryId() != null){
            Subcategory subcategory = new Subcategory();
            subcategory.setId(source.getSubcategoryId());
            product.setSubcategory(subcategory);
        }

        return product;
    }
}
