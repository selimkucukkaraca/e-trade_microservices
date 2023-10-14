package com.selim.productservice.repository;

import com.selim.entity.product.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {

    Optional<PromoCode> findByPublicId(String publicId);
    Optional<PromoCode> findByCodeText(String codeText);

}