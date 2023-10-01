package com.selim.shared.category.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CreateCategoryRequest {

    @NotBlank
    private String categoryName;
}
