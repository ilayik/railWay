package com.example.railway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
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

    public Schedule(Long id, String trainNumber, Date arrival, String stationName, Train train, Station station) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.arrival = arrival;
        this.stationName = stationName;
        this.train = train;
        this.station = station;
    }
}

