package com.example.sweater.controllers;

import com.example.sweater.modul.Train;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("/allTrain")
    public Iterable<Train> allTrainPage() {
        return trainService.getAllTrain();
    }

    @PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @PostMapping("/findTrainPost")
    public List<Train> findTrainPost(@RequestBody List<String> trainSearchParam) throws ParseException {
        return trainService.findTrain(trainSearchParam);
    }

    @PostMapping("/updateTrain")
    public Train updateTrain(@RequestBody Train train) {
        return trainService.updateTrain(train);
    }
}
