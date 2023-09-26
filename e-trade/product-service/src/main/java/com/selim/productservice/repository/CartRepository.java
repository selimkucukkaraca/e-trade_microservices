package com.selim.productservice.repository;

import com.selim.productservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartByCartId(String cartId);

}