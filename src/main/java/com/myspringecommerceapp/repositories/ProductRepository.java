package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategoryId(Long l);

    List<Product> findBySubcategoryId(Long l);


    List<Product> findByCategoryIdAndSubcategoryIdOrderByNameAsc(Long categoryId, Long subcategoryId);

    List<Product> findByCategoryIdAndSubcategoryIdOrderByNameDesc(Long categoryId, Long subcategoryId);


}
