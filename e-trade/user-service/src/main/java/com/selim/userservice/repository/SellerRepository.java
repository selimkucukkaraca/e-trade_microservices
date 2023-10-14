package com.selim.userservice.repository;

import com.selim.entity.user.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findByMail(String mail);
    boolean existsSellerByMail(String mail);
}