package com.example.railway.service;


import com.example.railway.model.Schedule;
import com.example.railway.model.Station;
import com.example.railway.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ScheduleService {

    private final ScheduleRepo scheduleRepo;

    private final TrainService trainService;

    private final StationService stationService;

    @Autowired
    public ScheduleService(ScheduleRepo scheduleRepo, TrainService trainService, StationService stationService) {
        this.scheduleRepo = scheduleRepo;
        this.trainService = trainService;
        this.stationService = stationService;
    }

    public Schedule addSchedule(Schedule schedule) throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(schedule.getArrival().toString());
        Schedule newSchedule = new Schedule();
        newSchedule.setArrival(date);
        newSchedule.setStationName(schedule.getStationName());
        newSchedule.setTrainNumber(schedule.getTrainNumber());
        newSchedule.setTrain(trainService.getTrainByNumber(schedule.getTrainNumber()));
        newSchedule.setStation(stationService.getStationByName(schedule.getStationName()));
        return scheduleRepo.save(newSchedule);
    }

    public Iterable<Schedule> getSchedules() {
        return scheduleRepo.findAll();
    }

    public List<Schedule> getSchedulesByStation(Station station) {
        List<Schedule> stationSchedules = new ArrayList<>();
        for (Schedule schedule : getSchedules()) {
            if (schedule.getStationName().equals(station.getName())) {
                stationSchedules.add(schedule);
            }
        }
        return stationSchedules;
    }

    public List<Schedule> getSchedulesByTrainNumber(String TrainNumber) {
        List<Schedule> trainSchedules = new ArrayList<>();
        for (Schedule schedule : getSchedules()) {
            if (schedule.getTrainNumber().equals(TrainNumber)) {
                trainSchedules.add(schedule);
            }
        }
        return trainSchedules;
    }


}
