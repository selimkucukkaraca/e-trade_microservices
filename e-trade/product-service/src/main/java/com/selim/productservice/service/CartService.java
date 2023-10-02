package com.selim.productservice.service;

import com.selim.entity.product.Cart;
import com.selim.entity.product.Product;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.CartRepository;
import com.selim.shared.product.CartDto;
import com.selim.shared.product.converter.CartConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartConverter cartConverter;
    private final ProductService productService;
    private final UserServiceClient userServiceClient;

    @CachePut(value = "carts", key = "#productId")
    public CartDto save(String mail, String productId) {
        var fromDbUser = userServiceClient.getUserByMail(mail).getBody();
        var fromProduct = productService.getProductObjectByProductId(productId);
        List<Product> products = List.of(fromProduct);

        Cart cart = new Cart(products,fromDbUser);
        fromProduct.setStock(fromProduct.getStock() - 1);
        cartRepository.save(cart);
        productService.updateProduct(fromProduct);
        return cartConverter.convertToDto(cart);
    }

    protected Cart getCart(String cartId) {
        return cartRepository.findCartByCartId(cartId);
    }

    @CacheEvict(value = "carts", key = "#cartId")
    public void deleteByCartId(String cartId) {
        var fromCart = getCart(cartId);
        cartRepository.delete(fromCart);
    }
}