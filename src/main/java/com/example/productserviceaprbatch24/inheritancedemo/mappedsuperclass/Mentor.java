package com.example.productserviceaprbatch24.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_mentor")
public class Mentor extends User{
    private String compName;
    private double avgrating;
}
