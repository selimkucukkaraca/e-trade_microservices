package com.selim.categoryservice.repository;

import com.selim.categoryservice.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    SubCategory findBySubCategoryName(String subCategoryName);
    boolean existsBySubCategoryName(String subCategoryName);
}
