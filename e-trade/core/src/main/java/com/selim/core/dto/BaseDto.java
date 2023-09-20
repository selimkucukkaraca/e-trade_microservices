package com.selim.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseDto implements Serializable {

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updateDate;
}
