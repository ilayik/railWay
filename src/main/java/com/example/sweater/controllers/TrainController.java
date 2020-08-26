package com.example.sweater.controllers;

import com.example.sweater.modul.Train;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @GetMapping("/allTrain")
    public String allTrainPage(Model model) {
        model.addAttribute("allTrain", trainService.getAllTrain());
        return "stuff/allTrain";
    }

    @GetMapping("/newTrainGet")
    public String newTrainGet(Model model){
        model.addAttribute("allStation",stationService.getAllStation());
        return "stuff/newTrain";
    }

    @PostMapping ("/newTrainPost")
    public String newTrainPost(@RequestParam (name = "number") String number,
                               @RequestParam (name = "capacity") String capacity) {
        trainService.setLostTrainNumber(number);
        trainService.addTrain(capacity,number);
        return "stuff/newTrain";
    }

    @GetMapping("/findTrainGet")
    public String findTrainGet (){
        return "passengers/findTrain";
    }

    @PostMapping("/findTrainPost")
    public String findTrainPost (@RequestParam(name = "stationA", defaultValue = "") String stationA,
                                 @RequestParam(name = "stationB", defaultValue = "") String stationB,
                                 @RequestParam(name = "DateA", defaultValue = "01.11.1993") String arrivalA,
                                 @RequestParam(name = "DateB", defaultValue = "20.11.1993") String arrivalB,
                                 Model model) throws ParseException {
        model.addAttribute("allStations",stationService.getAllStation());
        List<Train> mustTrains = trainService.findTrain(stationA, stationB, arrivalA, arrivalB);
        model.addAttribute("mustTrains",mustTrains);
        return "passengers/findTrain";
    }



}
