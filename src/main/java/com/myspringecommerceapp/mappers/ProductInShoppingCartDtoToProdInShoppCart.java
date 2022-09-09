package com.myspringecommerceapp.mappers;


import com.myspringecommerceapp.model.ProductInShoppingCart;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.modelDTO.ProductInShoppingCartDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ProductInShoppingCartDtoToProdInShoppCart implements Converter<ProductInShoppingCartDTO, ProductInShoppingCart> {

    private final ProductDtoToProduct productDtoToProduct;
    private final ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart;

    public ProductInShoppingCartDtoToProdInShoppCart(ProductDtoToProduct productDtoToProduct, ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart) {
        this.productDtoToProduct = productDtoToProduct;
        this.shoppingCartDtoToShoppingCart = shoppingCartDtoToShoppingCart;
    }

    @Synchronized
    @Nullable
    @Override
    public ProductInShoppingCart convert(ProductInShoppingCartDTO source) {
        if(source == null) return null;

        final ProductInShoppingCart productInShoppingCart = new ProductInShoppingCart();

        productInShoppingCart.setId(source.getId());
        productInShoppingCart.setProduct(productDtoToProduct.convert(source.getProduct()));
        productInShoppingCart.setQuantity(source.getQuantity());
        productInShoppingCart.setShoppingCart(shoppingCartDtoToShoppingCart.convert(source.getShoppingCart()));

        return productInShoppingCart;
    }
}
