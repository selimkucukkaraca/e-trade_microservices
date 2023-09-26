package com.selim.productservice.repository;

import com.selim.productservice.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    Optional<ProductComment> findProductCommentByProductCommentId(String productCommentId);

}