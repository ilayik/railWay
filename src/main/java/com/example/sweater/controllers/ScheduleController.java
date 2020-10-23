package com.example.sweater.controllers;

import com.example.sweater.modul.Schedule;
import com.example.sweater.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/allSchedules")
    public Iterable<Schedule> getAllStations() {
        return scheduleService.getAllSchedule();
    }

    @PostMapping("/newScheduleStation")
    public Schedule addSchedule(@RequestParam(name = "arrival") String arrival, // добавляет расписание к станции
                                @RequestParam(name = "number") String number,
                                @RequestParam(name = "stationName") String stationName
    ) throws ParseException {
        return scheduleService.addSchedule(arrival, number, stationName);
    }

    @GetMapping("/schedulesByStation")
    public List<Schedule> schedulesByStations(@RequestParam(name = "stationName") String stationName) {
        return scheduleService.getSchedulesByStationName(stationName);
    }
}
