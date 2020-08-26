package com.example.sweater.repository;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.modul.Train;
import com.example.sweater.repo.TrainRepo;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    private TrainService trainService;
    @Autowired
    private StationService stationService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private TrainRepo trainRepo;
    @Test
    public void getStationByName() {
        List<Schedule> schedules = stationService.getStationByName("StationName2").getSchedules();
        for (Schedule schedule:schedules) {
            System.out.println(schedule.toString());
        }
    }
    @Test
    public void TrainStations (){
        String trainNumber = "1111";
        List<Station> TrainStations = new ArrayList<>();
        Train train = trainService.getTrainByNumber(trainNumber);
        List<Schedule> schedules = train.getSchedules();
        for (Schedule schedule: schedules) {
            TrainStations.add(schedule.getStation());
        }
        for (Station station:TrainStations) {
            System.out.println(station);
        }
    }

    @Test
    public void getArrivalByTrain(){
        String trainNumber = "33";
        Station station = new Station();
        station.setName("stationName9");
        station.setSchedules(scheduleService.getSchedulesByStationName(station.getName()));
        Date arrival = new Date();
        List<Schedule> schedules = station.getSchedules();
        for (Schedule schedule: schedules) {
            if(schedule.getTrainNumber().equals(trainNumber)){
                arrival = schedule.getArrival();
            }
        }
        System.out.println(arrival);
    }

    @Test
    public void findTrain (){
        String stationNameA = "stationName9";
        String stationNameB = "StationName1";
        for (Train train: trainRepo.findAll()) {
            int ch = 0;
            for (Station station: trainService.TrainStations(train.getNumber())) {
                if((station.getName().equals(stationNameA))||(station.getName().equals(stationNameB))){
                    ch++;
                }
            }
            if(ch==2){
                System.out.println(train);
            }
        }
    }

    @Test
    public void findTrainFull () throws ParseException {
        List<Train> trains = new ArrayList<>();

        String stationNameA = "";//"stationName9";
        String stationNameB = "";//""StationName1";

        String strArrivalA = "01.11.1993";
        String strArrivalB = "20.11.1993";
        Date arrivalA = new SimpleDateFormat("dd.MM.yyyy").parse(strArrivalA);
        Date arrivalB = new SimpleDateFormat("dd.MM.yyyy").parse(strArrivalB);

        Station stationA = stationService.getStationByName(stationNameA);
        Station stationB = stationService.getStationByName(stationNameB);

        for (Train train: trainRepo.findAll()) {
            int ch = 0;
            for (Station station: trainService.TrainStations(train.getNumber())) {
                if((station.getName().equals(stationNameA))||(station.getName().equals(stationNameB))){
                    ch++;
                }
            }
            if(ch==2){
                Date trainArrivalA = stationService.getArrivalByTrain(stationA, train.getNumber());//время прибытия поезда на станцию stationNameA
                Date trainArrivalB = stationService.getArrivalByTrain(stationB, train.getNumber());//время прибытия поезда на станцию stationNameB

                if(trainArrivalA.getTime() < trainArrivalB.getTime()){ //сравнение времени прибытия поезда на станции stationNameA и stationNameB (в правильную ли сторону он едет)
                    if((trainArrivalA.getTime()>arrivalA.getTime())&&(trainArrivalB.getTime()<arrivalB.getTime())){//проверка на соответствие промежутку времени arrivalA и arrivalB
                        trains.add(train);
                    }
                }
            }
        }
        if(!trains.isEmpty()) {
            for (Train train : trains) {
                System.out.println(train);
            }
        }else System.out.println("NET TAKOGO POEZA");
    }


}
