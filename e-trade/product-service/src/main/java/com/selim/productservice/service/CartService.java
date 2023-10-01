package com.selim.productservice.service;

import com.selim.entity.product.Cart;
import com.selim.entity.product.Product;
import com.selim.productservice.repository.CartRepository;
import com.selim.shared.product.CartDto;
import com.selim.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartConverter cartConverter;
    private final UserService userService;
    private final ProductService productService;



    public CartDto save(String mail, String productId) {
        var fromUser = userService.getUserByMail(mail);
        var fromProduct = productService.getProductObjectByProductId(productId);
        List<Product> products = List.of(fromProduct);

        Cart cart = new Cart(products, fromUser);
        fromProduct.setStock(fromProduct.getStock() - 1);
        cartRepository.save(cart);
        productService.updateProduct(fromProduct);
        return cartConverter.convertToDto(cart);
    }

    protected Cart getCart(String cartId) {
        return cartRepository.findCartByCartId(cartId);
    }

    public void deleteByCartId(String cartId) {
        var fromCart = getCart(cartId);
        cartRepository.delete(fromCart);
    }
}