package com.selim.categoryservice.model;

import com.selim.core.entity.BaseEntity;
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
