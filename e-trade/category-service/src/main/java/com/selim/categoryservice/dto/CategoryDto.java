package com.selim.categoryservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class CategoryDto implements Serializable {

    private String categoryName;
}
