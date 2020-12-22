package com.example.sweater.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public @Data
class Role {

    @Id
    private Integer id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public Role() {
    }


}