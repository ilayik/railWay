package com.example.sweater.modul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String trainNumber;
    private Date arrival;
    private String stationName;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "train_id")
    private Train train;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "station_id")
    private Station station;

    public Schedule() {
    }

    public Schedule(Integer id, String trainNumber, Date arrival, String stationName) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.arrival = arrival;
        this.stationName = stationName;
    }

    public Schedule(Integer id, String trainNumber, Date arrival, String stationName, Station station) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.arrival = arrival;
        this.stationName = stationName;
        this.station = station;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

}

