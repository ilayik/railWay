package com.example.sweater.modul;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private Integer trainNumber;
    private Integer passenger;

    public Ticket() {
    }

    public Ticket(int trainNumber, Integer passengerId) {
        this.trainNumber = trainNumber;
        this.passenger = passengerId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getPassengerId() {
        return passenger;
    }

    public void setPassengerId(Integer passengerId) {
        this.passenger = passengerId;
    }
}

