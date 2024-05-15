package com.example.productserviceaprbatch24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VipProducts extends BaseModel {

    @ManyToOne
    Category category1;
}
