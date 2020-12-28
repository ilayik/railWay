package com.example.railway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String number;
    private String capacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "train")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "train")
    private List<Ticket> tickets;

}

