package com.example.sweater.controllers;

import com.example.sweater.modul.Schedule;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StationController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    @GetMapping("/newStationGet")
    public String getAllStations() {
        return "stuff/newStation";
}

    @PostMapping("/newStationPost")
    public String addNewStation(@RequestParam (name = "stationName", defaultValue = "someStationName") String stationName,
                                            Model model) {
        stationService.setLostStationName(stationName);
        stationService.addStation(stationName);
        model.addAttribute("lostStationName", stationService.getLostStationName());
        model.addAttribute("allTrain",trainService.getAllTrain());
        return "stuff/newScheduleInStation";
    }


    @PostMapping("/addSchedulesInNewStation")
    public String addScheduleInNewStation() {
        String lostStationName = stationService.getLostStationName();
        Iterable<Schedule> newIterable = scheduleService.getSchedulesByStationName(lostStationName);
        List<Schedule> schedulesByStationName = new ArrayList<>();
        newIterable.forEach(schedulesByStationName::add);
        stationService.getStationByName(lostStationName).setSchedules(schedulesByStationName);
        return "stuff/FinishAddStation";
    }
}
