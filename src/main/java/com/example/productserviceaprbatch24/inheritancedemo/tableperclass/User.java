package com.example.productserviceaprbatch24.inheritancedemo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name="tpc_users")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
