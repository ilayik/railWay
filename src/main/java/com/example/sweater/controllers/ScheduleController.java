package com.example.sweater.controllers;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/allSchedules")
    @ResponseBody
    public Iterable<Schedule> getAllStations() {
        return scheduleService.getAllSchedule();
    }

    @PostMapping("/newScheduleStation")
    @ResponseBody
    public Schedule addSchedule(@RequestParam(name = "arrival")  String arrival, // добавляет расписание к станции
                                @RequestParam (name = "number") String number,
                                @RequestParam(name = "stationName")  String stationName
    ) throws ParseException {
        return scheduleService.addSchedule(arrival,number,stationName);
    }

    @GetMapping("/SchedulesByStation")
    @ResponseBody
    public List<Schedule> schedulesByStations(@RequestParam( name = "stationName") String stationName){
        return scheduleService.getSchedulesByStationName(stationName);
    }
}
