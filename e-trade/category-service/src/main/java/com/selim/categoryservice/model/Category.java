package com.selim.categoryservice.model;

import com.selim.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity{

    private String categoryName;
    @OneToMany
    @ToString.Exclude
    private List<SubCategory> subCategories;

}
