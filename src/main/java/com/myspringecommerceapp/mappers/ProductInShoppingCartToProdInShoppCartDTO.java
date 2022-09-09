package com.myspringecommerceapp.mappers;


import com.myspringecommerceapp.model.ProductInShoppingCart;
import com.myspringecommerceapp.modelDTO.ProductInShoppingCartDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ProductInShoppingCartToProdInShoppCartDTO implements Converter<ProductInShoppingCart, ProductInShoppingCartDTO> {

    private final ProductToProductDTO productToProductDTO;
//    private final ShoppingCartToShoppingCartDTO shoppingCartToShoppingCartDTO;


    public ProductInShoppingCartToProdInShoppCartDTO(ProductToProductDTO productToProductDTO) {
        this.productToProductDTO = productToProductDTO;
    }

    @Synchronized
    @Nullable
    @Override
    public ProductInShoppingCartDTO convert(ProductInShoppingCart source) {

        if(source==null) return null;

        final ProductInShoppingCartDTO productInShoppingCartDTO = new ProductInShoppingCartDTO();

        productInShoppingCartDTO.setId(source.getId());
        productInShoppingCartDTO.setProduct(productToProductDTO.convert(source.getProduct()));
        productInShoppingCartDTO.setQuantity(source.getQuantity());
        if(source.getShoppingCart() != null){
            productInShoppingCartDTO.setShoppingCartId(source.getShoppingCart().getId());
        }

        return productInShoppingCartDTO;
    }
}
