package com.example.sweater.controllers;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StationController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    @GetMapping("/allStation")
    @ResponseBody
    public Iterable<Station> getAllStations() {
        return stationService.getAllStation();
    }

    @PostMapping("/addStation")
    @ResponseBody
    public Station addNewStation(@RequestBody String stationName) {
        stationService.setLastStationName(stationName);
        return stationService.addStation(stationName);
    }


    @PostMapping("/addSchedulesInNewStation")
    @ResponseBody
    public Station addScheduleInLostStation() {
        String lastStationName = stationService.getLastStationName();
        List<Schedule> list = scheduleService.getSchedulesByStationName(lastStationName);
        stationService.getStationByName(lastStationName).setSchedules(list);
        return stationService.getStationByName(lastStationName);
    }
}
