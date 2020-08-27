package com.example.sweater.modul;

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
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "train", cascade = CascadeType.ALL)
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(
//            name = "schedule_train",
//            joinColumns = {@JoinColumn(name = "schedule_id")},
//            inverseJoinColumns = {@JoinColumn(name = "train_id")})
//    private List<Schedule> schedules;

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

    public List<Schedule> getTrainRoute() {
        return schedules;
    }

    public void setTrainRoute(List<Schedule> trainRoute) {
        this.schedules = trainRoute;
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

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}

