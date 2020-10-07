package com.example.sweater.modul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String number;
    private String capacity;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "train")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "train")
    private List<Ticket> tickets;

    public Train() {
    }

    public Train(String trainNumber, String capacity) {
        this.number = trainNumber;
        this.capacity = capacity;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String trainNumber) {
        this.number = trainNumber;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        if( schedules != null ){
            schedules.forEach(schedule -> {
                schedule.setTrain(this);
            });
        }
        this.schedules = schedules;
    }

}

