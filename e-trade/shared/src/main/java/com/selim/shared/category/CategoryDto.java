package com.selim.shared.category;

import com.selim.shared.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryDto extends BaseDto{

    private String categoryName;
}
