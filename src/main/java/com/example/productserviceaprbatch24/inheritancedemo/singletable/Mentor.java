package com.example.productserviceaprbatch24.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sc_mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String compName;
    private double avgrating;
}
