package com.selim.productservice.repository;

import com.selim.productservice.model.ConfirmedCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmedCartRepository extends JpaRepository<ConfirmedCart, Long> {
}
