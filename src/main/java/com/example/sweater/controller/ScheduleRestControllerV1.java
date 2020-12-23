package com.example.sweater.controller;

import com.example.sweater.model.Schedule;
import com.example.sweater.model.Station;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleRestControllerV1 {

    private final ScheduleService scheduleService;

    private final StationService stationService;

    @Autowired
    public ScheduleRestControllerV1(ScheduleService scheduleService, StationService stationService) {
        this.scheduleService = scheduleService;
        this.stationService = stationService;
    }


    @GetMapping
    public Iterable<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PostMapping
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        try {
            return scheduleService.addSchedule(schedule);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/by-station")
    public List<Schedule> getSchedulesByStation(@RequestBody Station station) {
        return scheduleService.getSchedulesByStation(station);
    }

    @PostMapping("/add-in-station")
    public Station addSchedulesInLastStation() {
        Station lastStation = stationService.getLastStation();
        List<Schedule> list = scheduleService.getSchedulesByStation(lastStation);
        lastStation.setSchedules(list);
        return lastStation;
    }
}
