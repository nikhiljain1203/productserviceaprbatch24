package com.example.productserviceaprbatch24.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_it")
public class Instructor extends User {
    private String specialisation;
}
