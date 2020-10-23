package com.example.sweater.service;


import com.example.sweater.modul.Schedule;
import com.example.sweater.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;


    public Schedule addSchedule(String arrival, String trainNumber, String stationName) throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(arrival);
        Schedule newSchedule = new Schedule();
        newSchedule.setArrival(date);
        newSchedule.setStationName(stationName);
        newSchedule.setTrainNumber(trainNumber);
        newSchedule.setTrain(trainService.getTrainByNumber(trainNumber));
        newSchedule.setStation(stationService.getStationByName(stationName));
        return scheduleRepo.save(newSchedule);
    }

    public Iterable<Schedule> getAllSchedule() {
        return scheduleRepo.findAll();
    }

    public List<Schedule> getSchedulesByStationName(String stationName) { // выдаём лист расписаний (номеПоезда-времяПрибытия) к нужной станции(ищет по имени станции)
        List<Schedule> stationSchedules = new ArrayList<>();
        for (Schedule schedule : getAllSchedule()) {
            if (schedule.getStationName().equals(stationName)) {
                stationSchedules.add(schedule);
            }
        }
        return stationSchedules;
    }

    public List<Schedule> getSchedulesByTrainNumber(String TrainNumber) { // выдаём лист расписаний (номеПоезда-времяПрибытия) к нужному поезду (по номеру поезда)
        List<Schedule> trainSchedules = new ArrayList<>();
        for (Schedule schedule : getAllSchedule()) {
            if (schedule.getTrainNumber().equals(TrainNumber)) {
                trainSchedules.add(schedule);
            }
        }
        return trainSchedules;
    }


}
