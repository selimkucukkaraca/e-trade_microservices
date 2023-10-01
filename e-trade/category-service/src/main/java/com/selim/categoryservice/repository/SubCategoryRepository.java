package com.selim.categoryservice.repository;

import com.selim.entity.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    SubCategory findBySubCategoryName(String subCategoryName);
    boolean existsBySubCategoryName(String subCategoryName);
}
