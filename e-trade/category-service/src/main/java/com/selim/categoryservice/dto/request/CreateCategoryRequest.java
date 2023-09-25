package com.selim.categoryservice.dto.request;

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
