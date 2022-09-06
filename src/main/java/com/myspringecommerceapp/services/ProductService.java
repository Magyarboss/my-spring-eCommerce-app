package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;

import java.util.Set;

public interface ProductService {

    Set<ProductDTO> getProducts();

    Product findById(Long l);

    ProductDTO findDTOById(Long l);

    Set<ProductDTO> findByCategoryId(Long l);

    Set<ProductDTO> findBySubcategoryId(Long l);

}
