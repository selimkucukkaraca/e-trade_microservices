package com.selim.productservice.service;

import com.selim.entity.product.Cart;
import com.selim.productservice.TestUtil;
import com.selim.productservice.client.UserServiceClient;
import com.selim.productservice.repository.CartRepository;
import com.selim.shared.product.converter.CartConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CartServiceTest extends TestUtil {

    private CartRepository cartRepository;
    private CartConverter cartConverter;
    private ProductService productService;
    private UserServiceClient userServiceClient;
    private CartService cartService;

    @BeforeEach
    public void setUp(){
        cartRepository = mock(CartRepository.class);
        cartConverter = mock(CartConverter.class);
        productService = mock(ProductService.class);
        userServiceClient = mock(UserServiceClient.class);
        cartService = new CartService(cartRepository,cartConverter,productService,userServiceClient);
    }

    @Test
    void saveCart_itShouldReturnCartDto(){
        //TODO
    }

    @Test
    void getCart_itShouldReturnCart() {

        Cart cart = getCartList(null, null).get(0);
        String cartId = "test";

        when(cartRepository.findByCartId(cartId)).thenReturn(cart);

        Cart response = cartService.getCart(cartId);

        assertEquals(response, cart);
        verify(cartRepository).findByCartId(cartId);

    }

    @Test
    void deleteByCartId() {

        Cart cart = getCartList(null, null).get(0);
        String cartId = "test";

        when(cartRepository.findByCartId(cartId)).thenReturn(cart);

        cartService.deleteByCartId(cartId);

        verify(cartRepository).delete(cart);

    }

}