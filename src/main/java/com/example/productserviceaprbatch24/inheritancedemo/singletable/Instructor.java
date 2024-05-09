package com.example.productserviceaprbatch24.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_it")
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String specialisation;
}
