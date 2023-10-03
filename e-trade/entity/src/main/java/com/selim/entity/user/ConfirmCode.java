package com.selim.entity.user;

import com.selim.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.Random;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmCode extends BaseEntity {

    private int code = new Random().nextInt(1000);

    public ConfirmCode(Long id,int code) {
        super.setId(id);
        this.code = code;
    }
}