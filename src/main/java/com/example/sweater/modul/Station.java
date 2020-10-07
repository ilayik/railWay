package com.example.sweater.modul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
//    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "station", cascade = CascadeType.ALL)
    private List<Schedule> schedules;


    public Station() {
    }

//    public Station(String name, List<Schedule> schedule) {
//        this.name = name;
//        this.schedules = schedule;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        if( schedules != null ){
            schedules.forEach(schedule -> {
                schedule.setStation(this);
            });
        }
        this.schedules = schedules;
    }

}
