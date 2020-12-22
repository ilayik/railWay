package com.example.sweater.controller;

import com.example.sweater.model.Train;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trains")
public class TrainRestControllerV1 {

    private final TrainService trainService;

    @Autowired
    public TrainRestControllerV1(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public Iterable<Train> getTrains() {
        return trainService.getTrain();
    }

    @PostMapping
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @PostMapping("/find")
    public List<Train> findTrain(@RequestBody List<String> trainSearchParam) {
        try {
            return trainService.findTrain(trainSearchParam);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/update")
    public Train updateTrain(@RequestBody Train train) {
        return trainService.updateTrain(train);
    }
}
