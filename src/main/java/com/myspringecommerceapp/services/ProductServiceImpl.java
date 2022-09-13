package com.myspringecommerceapp.services;

import com.myspringecommerceapp.exceptions.NotFoundException;
import com.myspringecommerceapp.mappers.ProductDtoToProduct;
import com.myspringecommerceapp.mappers.ProductToProductDTO;
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
//        for(ProductDTO productDTO : productDTOList){
//            System.out.println("This is product DTO: "+ productDTO.toString());
//        }
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
//            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getCategory().getId());
        });

        return productDTOList;
    }

    @Override
    public List<ProductDTO> findBySubcategoryId(Long l) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findBySubcategoryId(l).forEach(product -> {
            productDTOList.add(productToProductDTO.convert(product));
//            System.out.println("Find by categoryId id = " + l + "Product category id = " + product.getSubcategory().getId());
        });

        return productDTOList;
    }

    @Override
    public List<ProductDTO> sortProductDTOListByNameASC(List<ProductDTO> productDTOList) {
        productDTOList.sort( (o1, o2) -> o1.getName().compareTo(o2.getName()) );

        return productDTOList;
    }

    @Override
    public List<ProductDTO> sortProductDTOListByNameDESC(List<ProductDTO> productDTOList) {
        productDTOList.sort( (o1, o2) -> o2.getName().compareTo(o1.getName()) );

        return productDTOList;
    }

    @Override
    public List<ProductDTO> sortProductDTOListByPriceASC(List<ProductDTO> productDTOList) {
        productDTOList.sort( (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()) );

        return productDTOList;
    }

    @Override
    public List<ProductDTO> sortProductDTOListByPriceDESC(List<ProductDTO> productDTOList) {
        productDTOList.sort( (o1, o2) -> o2.getPrice().compareTo(o1.getPrice()) );

        return productDTOList;
    }

    @Override
    public List<ProductDTO> sortProductDTOListBy(List<ProductDTO> productDTOList, String orderBy) {

        switch (orderBy) {
            case "nameASC":
                productDTOList = sortProductDTOListByNameASC(productDTOList);
                break;
            case "nameDESC":
                productDTOList = sortProductDTOListByNameDESC(productDTOList);
                break;
            case "priceASC":
                productDTOList = sortProductDTOListByPriceASC(productDTOList);
                break;
            case "priceDESC":
                productDTOList = sortProductDTOListByPriceDESC(productDTOList);
                break;
        }

        return productDTOList;
    }

    //    @Override
//    public List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByNameAsc(Long categoryId, Long subcategoryId) {
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        productRepository.findByCategoryIdAndSubcategoryIdOrderByNameAsc(categoryId, subcategoryId).forEach(product -> {
//            productDTOList.add(productToProductDTO.convert(product));
//            System.out.println("Product list orderd by name ASC : " + product.getName());
//        });
//
//        return productDTOList;
//    }
//
//    @Override
//    public List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByNameDesc(Long categoryId, Long subcategoryId) {
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        productRepository.findByCategoryIdAndSubcategoryIdOrderByNameDesc(categoryId, subcategoryId).forEach(product -> {
//            productDTOList.add(productToProductDTO.convert(product));
//            System.out.println("Product list orderd by name DESC : " + product.getName());
//        });
//
//        return productDTOList;
//    }
//
//    @Override
//    public List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByPrice(Long categoryId, Long subcategoryId) {
//        return null;
//    }
//
//    @Override
//    public List<ProductDTO> findByCategoryIdAndSubcategoryIdOrderByPriceDesc(Long categoryId, Long subcategoryId) {
//        return null;
//    }
}
