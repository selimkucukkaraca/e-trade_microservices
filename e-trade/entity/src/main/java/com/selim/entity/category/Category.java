package com.selim.entity.category;

import com.selim.entity.BaseEntity;
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

    public Category(Long id,String categoryName, List<SubCategory> subCategories) {
        super.setId(id);
        this.categoryName = categoryName;
        this.subCategories = subCategories;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
