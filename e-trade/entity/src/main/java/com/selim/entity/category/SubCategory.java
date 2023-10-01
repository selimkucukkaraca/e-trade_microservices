package com.selim.entity.category;

import com.selim.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubCategory extends BaseEntity {

    private String subCategoryName;

}
