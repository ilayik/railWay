package com.example.sweater.service;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StationService {

    String LastStationName = null;

    @Autowired
    private StationRepo stationRepo;


    public Station addStation(String name) { //добаляет станцию
        Station newStation = new Station();
        newStation.setName(name);
        return stationRepo.save(newStation);
    }

    public Iterable<Station> getAllStation() { // выдаёт список всех станций
        return stationRepo.findAll();
    }


    public Station getStationByName(String stationName) { //выдаёт станцию по заданому имини
        Station StationByName = null;
        for (Station station : stationRepo.findAll()) {
            if (station.getName().equals(stationName)) {
                StationByName = station;
            }
        }
        return StationByName;
    }

    public Date getArrivalByTrain(Station station, String trainNumber) {
        Date arrival = null;
        List<Schedule> schedules = station.getSchedules();
        for (Schedule schedule : schedules) {
            if (schedule.getTrainNumber().equals(trainNumber)) {
                arrival = schedule.getArrival();
            }
        }
        return arrival;
    }

    public String getLastStationName() {
        return LastStationName;
    }

    public void setLastStationName(String lastStationName) {
        LastStationName = lastStationName;
    }
}
