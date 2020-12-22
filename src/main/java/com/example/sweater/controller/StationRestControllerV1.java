package com.example.sweater.controller;

import com.example.sweater.model.Station;
import com.example.sweater.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stations")
public class StationRestControllerV1 {

    private final StationService stationService;

    @Autowired
    public StationRestControllerV1(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public Iterable<Station> getStations() {
        return stationService.getStations();
    }

    @PostMapping
    public Station addStation(@RequestBody Station station) {
        stationService.setLastStation(station);
        return stationService.addStation(station);
    }
}
