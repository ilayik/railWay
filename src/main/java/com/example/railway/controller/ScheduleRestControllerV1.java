package com.example.railway.controller;

import com.example.railway.model.Schedule;
import com.example.railway.model.Station;
import com.example.railway.service.ScheduleService;
import com.example.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('read')")
    public Iterable<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        try {
            return scheduleService.addSchedule(schedule);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/by-station")
    @PreAuthorize("hasAuthority('read')")
    public List<Schedule> getSchedulesByStation(@RequestBody Station station) {
        return scheduleService.getSchedulesByStation(station);
    }

    @PostMapping("/add-in-station")
    @PreAuthorize("hasAuthority('write')")
    public Station addSchedulesInLastStation() {
        Station lastStation = stationService.getLastStation();
        List<Schedule> list = scheduleService.getSchedulesByStation(lastStation);
        lastStation.setSchedules(list);
        return lastStation;
    }
}
