package com.example.mymangausersystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(name = "role_name")
    @Getter @Setter
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
