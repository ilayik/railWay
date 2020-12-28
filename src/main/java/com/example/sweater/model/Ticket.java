package com.example.sweater.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "train_id")
    private Train train;

}

