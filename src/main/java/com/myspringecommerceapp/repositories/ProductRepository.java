package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategoryId(Long l);

    List<Product> findBySubcategoryId(Long l);


//    List<Product> findByCategoryIdAndSubcategoryIdOrderByNameAsc(Long categoryId, Long subcategoryId);
//
// @Query()
//    List<Product> findByCategoryIdAndSubcategoryIdOrderByNameDesc(Long categoryId, Long subcategoryId);
//
//    List<Product> findByCategoryIdAndSubcategoryIdOrderByPrice(Long categoryId, Long subcategoryId);
//
//    List<Product> findByCategoryIdAndSubcategoryIdOrderByPriceDesc(Long categoryId, Long subcategoryId);

}
