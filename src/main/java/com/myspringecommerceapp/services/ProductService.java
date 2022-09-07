package com.myspringecommerceapp.services;

import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;

import java.util.List;
import java.util.Set;

public interface ProductService {

    List<ProductDTO> getProducts();

    Product findById(Long l);

    ProductDTO findDTOById(Long l);

    List<ProductDTO> findByCategoryId(Long l);

    List<ProductDTO> findBySubcategoryId(Long l);

}
