package com.example.productserviceaprbatch24.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_ta")
public class TA extends User {
    private int numberOfSession;
    private double avgrating;
}
