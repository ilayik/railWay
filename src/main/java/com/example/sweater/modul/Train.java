package com.example.sweater.modul;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    private int trainNumber;
    private String trainRoute; //тут должен быть List<String>(что бы я заполнил его Station.getName()) но выдает ошибку хз
    private int trainCapacity;

    public Train() {
    }

    public Train(int trainNumber, String trainRoute, int trainCapacity) {
        this.trainNumber = trainNumber;
        this.trainRoute = trainRoute;
        this.trainCapacity = trainCapacity;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(String trainRoute) {
        this.trainRoute = trainRoute;
    }

    public int getTrainCapacity() {
        return trainCapacity;
    }

    public void setTrainCapacity(int trainCapacity) {
        this.trainCapacity = trainCapacity;
    }
}

