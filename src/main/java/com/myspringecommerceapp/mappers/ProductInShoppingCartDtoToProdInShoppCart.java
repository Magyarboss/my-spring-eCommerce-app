package com.myspringecommerceapp.mappers;


import com.myspringecommerceapp.model.ProductInShoppingCart;
import com.myspringecommerceapp.model.ShoppingCart;
import com.myspringecommerceapp.modelDTO.ProductDTO;
import com.myspringecommerceapp.modelDTO.ProductInShoppingCartDTO;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ProductInShoppingCartDtoToProdInShoppCart implements Converter<ProductInShoppingCartDTO, ProductInShoppingCart> {

    private final ProductDtoToProduct productDtoToProduct;
//    private final ShoppingCartDtoToShoppingCart shoppingCartDtoToShoppingCart;


    public ProductInShoppingCartDtoToProdInShoppCart(ProductDtoToProduct productDtoToProduct) {
        this.productDtoToProduct = productDtoToProduct;
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

        if(source.getShoppingCartId() != null){
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setId(source.getShoppingCartId());
            productInShoppingCart.setShoppingCart(shoppingCart);
            shoppingCart.getProductInShoppingCartList().add(productInShoppingCart);
        }

        return productInShoppingCart;
    }
}
