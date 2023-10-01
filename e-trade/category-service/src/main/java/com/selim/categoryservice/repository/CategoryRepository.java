package com.selim.categoryservice.repository;

import com.selim.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
    boolean existsByCategoryName(String categoryName);
}
