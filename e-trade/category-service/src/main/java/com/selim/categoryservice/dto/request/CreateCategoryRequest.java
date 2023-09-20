package com.selim.categoryservice.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateCategoryRequest {

    @NotBlank
    private String categoryName;
}
