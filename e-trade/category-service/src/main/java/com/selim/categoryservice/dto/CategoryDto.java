package com.selim.categoryservice.dto;

import com.selim.core.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryDto extends BaseDto implements Serializable {

    private String categoryName;
}
