package com.example.sweater.controllers;

import com.example.sweater.modul.Train;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.List;

@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @GetMapping("/allTrain")
    @ResponseBody
    public Iterable<Train> allTrainPage() {
        return trainService.getAllTrain();
    }

    @PostMapping ("/addTrain")
    @ResponseBody
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @PostMapping("/findTrainPost")
    @ResponseBody
    public List<Train> findTrainPost (@RequestBody List<String> trainSearchParam) throws ParseException {
        return trainService.findTrain(trainSearchParam);
    }

    @PostMapping ("/updateTrain")
    @ResponseBody
    public Train updateTrain(@RequestBody Train train) {
        return trainService.updateTrain(train);
    }
}
