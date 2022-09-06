package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.mappers.ProductDtoToProduct;
import com.myspringecommerceapp.mappers.ProductToProductDTO;
import com.myspringecommerceapp.model.Category;
import com.myspringecommerceapp.model.Product;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
    public Set<ProductDTO> getProducts() {
        Set<ProductDTO> productDTOSet = new HashSet<>();

        productRepository.findAll().forEach(product -> {
            productDTOSet.add(productToProductDTO.convert(product));
        });
        for(ProductDTO productDTO : productDTOSet){
            System.out.println("This is product DTO: "+ productDTO.toString());
        }
        return productDTOSet;
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
    public Set<ProductDTO> findByCategoryId(Long l) {
        Set<ProductDTO> productDTOSet = new HashSet<>();
        productRepository.findByCategoryId(l).forEach(product -> {
            productDTOSet.add(productToProductDTO.convert(product));
            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getCategory().getId());
        });

        return productDTOSet;
    }

    @Override
    public Set<ProductDTO> findBySubcategoryId(Long l) {
        Set<ProductDTO> productDTOSet = new HashSet<>();
        productRepository.findBySubcategoryId(l).forEach(product -> {
            productDTOSet.add(productToProductDTO.convert(product));
            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getSubcategory().getId());
        });

        return productDTOSet;
    }
}
