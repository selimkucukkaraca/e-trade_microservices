package com.selim.shared.category.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateSubCategoryRequest {

    private String categoryName;
    private String subCategoryName;
}
