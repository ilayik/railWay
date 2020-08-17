package com.example.sweater.controllers;

import com.example.sweater.modul.Passenger;
import com.example.sweater.modul.Station;
import com.example.sweater.repo.PassengerRepo;
import com.example.sweater.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StuffController {
    @Autowired
    private StationRepo stationRepo;

    @GetMapping("/stuff")
    public String stuffPage() {
        return "stuff/stuff";
    }

    @GetMapping("/newTrain")
    public String newTrainPage() {
        return "stuff/newTrain";
    }

    @GetMapping("/allTrain")
    public String allTrainPage() {
        return "stuff/allTrain";
    }

    @GetMapping("/lookPassTrain")
    public String lookPassTrainPage() {
        return "stuff/lookPassTrain";
    }

    @GetMapping("/newStation")
    public String newStationPage(Model model) {
        Iterable<Station> allStation = stationRepo.findAll();
        model.addAttribute("allStationList", allStation);
        return "stuff/newStation";
    }

    @PostMapping("/newStation")
    public String addNewStation(@RequestParam(name = "stationName") String stationName,
                                Model model) {
        Station newStation = new Station(stationName, null);
        stationRepo.save(newStation);
        Iterable<Station> allStation = stationRepo.findAll();
        model.addAttribute("allStationList", allStation);
        return "stuff/newStation";
    }

}
