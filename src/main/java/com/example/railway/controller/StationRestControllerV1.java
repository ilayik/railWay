package com.example.railway.controller;

import com.example.railway.model.Station;
import com.example.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('read')")
    public Iterable<Station> getStations() {
        return stationService.getStations();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public Station addStation(@RequestBody Station station) {
        stationService.setLastStationName(station.getName());
        return stationService.addStation(station);
    }
}
