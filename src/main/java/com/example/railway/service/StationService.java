package com.example.railway.service;

import com.example.railway.model.Schedule;
import com.example.railway.model.Station;
import com.example.railway.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StationService {

    String LastStationName = null;

    private final StationRepo stationRepo;

    @Autowired
    public StationService(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public Station addStation(Station station) {
        Station newStation = new Station();

        newStation.setName(station.getName());

        return stationRepo.save(newStation);
    }

    public Iterable<Station> getStations() {
        return stationRepo.findAll();
    }

    public Station getStationByName(String stationName) {
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
