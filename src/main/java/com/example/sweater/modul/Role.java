package com.example.sweater.modul;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "role")
public class Role {

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
}
