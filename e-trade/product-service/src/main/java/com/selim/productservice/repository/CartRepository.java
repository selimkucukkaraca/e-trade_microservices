package com.selim.productservice.repository;

import com.selim.entity.product.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByCartId(String cartId);

}