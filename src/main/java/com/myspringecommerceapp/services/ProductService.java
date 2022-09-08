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

    // ----- SORTIRANJE PREKO LIST.SORT() -----

    List<ProductDTO> sortProductDTOListByNameASC(List<ProductDTO> productDTOList);

    List<ProductDTO> sortProductDTOListByNameDESC(List<ProductDTO> productDTOList);

    List<ProductDTO> sortProductDTOListByPriceASC(List<ProductDTO> productDTOList);

    List<ProductDTO> sortProductDTOListByPriceDESC(List<ProductDTO> productDTOList);

    List<ProductDTO> sortProductDTOListBy(List<ProductDTO> productDTOList, String orderBy);

    // ----- SORTIRANJE PREKO BAZE -----

//    List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByNameAsc(Long categoryId, Long subcategoryId);
//
//    List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByNameDesc(Long categoryId, Long subcategoryId);
//
//    List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByPrice(Long categoryId, Long subcategoryId);
//
//    List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByPriceDesc(Long categoryId, Long subcategoryId);
}
