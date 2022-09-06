package com.myspringecommerceapp.repositories;

import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Set<Product> findByCategoryId(Long l);

    Set<Product> findBySubcategoryId(Long l);

}
