package com.example.sweater.controllers;

import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    @GetMapping("/newScheduleStationGet")
    public String getAllStation(Model model) {
        model.addAttribute("allScheduleList",scheduleService.getAllSchedule());

        return "stuff/newScheduleInStation";
    }

    @PostMapping("/newScheduleStationPost")
    public String addSchedule(@RequestParam(name = "arrival")  String arrival,
                              @RequestParam (name = "number") String number,
                              Model model) throws ParseException {

        model.addAttribute("allTrain",trainService.getAllTrain());
        String lostStationName = stationService.getLostStationName();
        model.addAttribute("lostStationName", lostStationName);
        scheduleService.addSchedule(arrival,number,lostStationName);
        model.addAttribute("schedulesByStationName",scheduleService.getSchedulesByStationName(lostStationName));
        return "stuff/newScheduleInStation";
    }
    @GetMapping("/SchedulesByStationGet")
    public String SchedulesStati1on(Model model){
        model.addAttribute("allStation",stationService.getAllStation());
        return "passengers/SchedulesStation";
    }

    @PostMapping("/SchedulesByStationPost")
    public String SchedulesStation(@RequestParam( name = "stationName", defaultValue = "stationName") String stationName,
                                   Model model){
        model.addAttribute("allStation",stationService.getAllStation());
        model.addAttribute("scheduleByStationName", scheduleService.getSchedulesByStationName(stationName));
        return "passengers/SchedulesStation";
    }


}
