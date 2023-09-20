package com.selim.categoryservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSubCategoryRequest {

    private String categoryName;
    private String subCategoryName;
}
