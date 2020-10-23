package com.example.sweater.controllers;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @GetMapping("/allStation")
    public Iterable<Station> getAllStations() {
        return stationService.getAllStation();
    }

    @PostMapping("/addStation")
    public Station addNewStation(@RequestBody String stationName) {
        stationService.setLastStationName(stationName);
        return stationService.addStation(stationName);
    }

    @PostMapping("/addSchedulesInNewStation")
    public Station addScheduleInLostStation() {
        String lastStationName = stationService.getLastStationName();
        List<Schedule> list = scheduleService.getSchedulesByStationName(lastStationName);
        stationService.getStationByName(lastStationName).setSchedules(list);
        return stationService.getStationByName(lastStationName);
    }
}
