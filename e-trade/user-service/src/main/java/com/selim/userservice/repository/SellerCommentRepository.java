package com.selim.userservice.repository;

import com.selim.userservice.model.SellerComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerCommentRepository extends JpaRepository<SellerComment, Long> {

    Optional<SellerComment> findBySellerCommentId(String sellerCommentId);
}