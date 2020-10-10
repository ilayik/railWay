package com.example.sweater.service;

import com.example.sweater.modul.Schedule;
import com.example.sweater.modul.Station;
import com.example.sweater.modul.Train;
import com.example.sweater.repo.ScheduleRepo;
import com.example.sweater.repo.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private StationService stationService;

    @Autowired
    private ScheduleService scheduleService;



    public Train updateTrain(Train train) {
        Train tr = new Train();
        tr.setSchedules(scheduleService.getSchedulesByTrainNumber(train.getNumber()));
        tr.setCapacity(train.getCapacity());
        tr.setNumber(train.getNumber());
        tr.setId(train.getId());
        return trainRepo.save(tr);
    }

    public Train addTrain (Train train) { //добаляет траин
        Train newTrain = new Train();
        newTrain.setCapacity(train.getCapacity());
        newTrain.setNumber(train.getNumber());
        return trainRepo.save(newTrain);
    }

    public Iterable<Train> getAllTrain(){// выдаёт список всех станций
        return trainRepo.findAll();
    }

    public Train getTrainByNumber(String TrainNumber){ // выдаёт станцию по заданому имини
        Train TrainByNumber = null;
        for (Train train:trainRepo.findAll()) {
            if (train.getNumber().equals(TrainNumber)){
                TrainByNumber = train;
            }
        }
        return TrainByNumber;
    }

    public List<Station> TrainStations (String trainNumber){
        List<Station> TrainStations = new ArrayList<>();
        Train train = getTrainByNumber(trainNumber);
        List<Schedule> schedules = train.getSchedules();
        for (Schedule schedule: schedules) {
            TrainStations.add(schedule.getStation());
            }
        return TrainStations;
    }

//    public List<Train> findTrain (String stationNameA, String stationNameB, String strArrivalA, String strArrivalB) throws ParseException {trainSearchParam
        public List<Train> findTrain (List<String> trainSearchParam) throws ParseException {
        List<Train> trains = new ArrayList<>();

        Date arrivalA = new SimpleDateFormat("dd.MM.yyyy").parse(trainSearchParam.get(2));
        Date arrivalB = new SimpleDateFormat("dd.MM.yyyy").parse(trainSearchParam.get(3));

        Station stationA = stationService.getStationByName(trainSearchParam.get(0));
        Station stationB = stationService.getStationByName(trainSearchParam.get(1));

        for (Train train: trainRepo.findAll()) {

            int ch = 0;
            for (Station station: TrainStations(train.getNumber())) {
                if((station.getName().equals(trainSearchParam.get(0)))||(station.getName().equals(trainSearchParam.get(1)))){//проверка если ли в маршруте поезда станции stationNameA и stationNameA
                    ch++;
                }
            }
            if(ch==2){
                Date trainArrivalA = stationService.getArrivalByTrain(stationA, train.getNumber());//время прибытия поезда на станцию stationNameA
                Date trainArrivalB = stationService.getArrivalByTrain(stationB, train.getNumber());//время прибытия поезда на станцию stationNameB

                if(trainArrivalA.getTime() < trainArrivalB.getTime()){ //сравнение времени прибытия поезда на станции stationNameA и stationNameA (в правильную ли сторону он едет)
                    if((trainArrivalA.getTime()>=arrivalA.getTime())&&(trainArrivalB.getTime()<=arrivalB.getTime())){
                        trains.add(train);
                    }
                }
            }
        }
        return trains;
    }
}
