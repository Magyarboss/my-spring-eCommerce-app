package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.mappers.ProductDtoToProduct;
import com.myspringecommerceapp.mappers.ProductToProductDTO;
import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductToProductDTO productToProductDTO;

    private final ProductDtoToProduct productDtoToProduct;

    public ProductServiceImpl(ProductRepository productRepository, ProductToProductDTO productToProductDTO, ProductDtoToProduct productDtoToProduct) {
        this.productRepository = productRepository;
        this.productToProductDTO = productToProductDTO;
        this.productDtoToProduct = productDtoToProduct;
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();

        productRepository.findAll().forEach(product -> {
            productDTOList.add(productToProductDTO.convert(product));
        });
        for(ProductDTO productDTO : productDTOList){
            System.out.println("This is product DTO: "+ productDTO.toString());
        }
        return productDTOList;
    }

    @Override
    public Product findById(Long l) {

        Optional<Product> productOptional = productRepository.findById(l);
        if(productOptional.isEmpty()){
            throw new NotFoundException("Category Not Found. For ID value: " + l );
        }

        return  productOptional.get();
    }

    @Override
    public ProductDTO findDTOById(Long l) {
        return productToProductDTO.convert(findById(l));
    }

    @Override
    public List<ProductDTO> findByCategoryId(Long l) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findByCategoryId(l).forEach(product -> {
            productDTOList.add(productToProductDTO.convert(product));
            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getCategory().getId());
        });

        return productDTOList;
    }

    @Override
    public List<ProductDTO> findBySubcategoryId(Long l) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findBySubcategoryId(l).forEach(product -> {
            productDTOList.add(productToProductDTO.convert(product));
            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getSubcategory().getId());
        });

        return productDTOList;
    }
}
