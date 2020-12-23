package com.example.sweater.service;

import com.example.sweater.model.Schedule;
import com.example.sweater.model.Station;
import com.example.sweater.model.Train;
import com.example.sweater.repo.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainService {

    private final TrainRepo trainRepo;

    private final StationService stationService;

    @Autowired
    public TrainService(TrainRepo trainRepo, StationService stationService) {
        this.trainRepo = trainRepo;
        this.stationService = stationService;
    }


    public Train updateTrain(Train train) {
        Train t = new Train();
        t.setCapacity(train.getCapacity());
        t.setNumber(train.getNumber());
        t.setId(train.getId());
        return trainRepo.save(t);
    }

    public Train addTrain(Train train) {
        Train newTrain = new Train();
        newTrain.setCapacity(train.getCapacity());
        newTrain.setNumber(train.getNumber());
        return trainRepo.save(newTrain);
    }

    public Iterable<Train> getTrain() {
        return trainRepo.findAll();
    }

    public Train getTrainByNumber(String TrainNumber) {
        return trainRepo.findAll().stream().filter(t -> t.getNumber().
                equals(TrainNumber)).
                findFirst().
                orElse(null);

    }

    public List<Station> TrainStations(String trainNumber) {
        List<Station> TrainStations = new ArrayList<>();
        Train train = getTrainByNumber(trainNumber);
        List<Schedule> schedules = train.getSchedules();
        schedules.forEach(schedule -> TrainStations.add(schedule.getStation()));
        return TrainStations;
    }

    public List<Train> findTrain(List<String> trainSearchParam) throws ParseException {
        List<Train> trains = new ArrayList<>();

        Date arrivalA = new SimpleDateFormat("dd.MM.yyyy").parse(trainSearchParam.get(2));
        Date arrivalB = new SimpleDateFormat("dd.MM.yyyy").parse(trainSearchParam.get(3));

        Station stationA = stationService.getStationByName(trainSearchParam.get(0));
        Station stationB = stationService.getStationByName(trainSearchParam.get(1));

        for (Train train : trainRepo.findAll()) {

            int ch = 0;
            //проверка если ли в маршруте поезда станции stationNameA и stationNameA
            for (Station station : TrainStations(train.getNumber())) {
                if ((station.getName().equals(trainSearchParam.get(0))) || (station.getName().equals(trainSearchParam.get(1)))) {
                    ch++;
                }
            }
            if (ch == 2) {
                //время прибытия поезда на станцию stationNameA
                Date trainArrivalA = stationService.getArrivalByTrain(stationA, train.getNumber());
                //время прибытия поезда на станцию stationNameB
                Date trainArrivalB = stationService.getArrivalByTrain(stationB, train.getNumber());

                //сравнение времени прибытия поезда на станции stationNameA и stationNameA (в правильную ли сторону он едет)
                if (trainArrivalA.getTime() < trainArrivalB.getTime()) {
                    if ((trainArrivalA.getTime() >= arrivalA.getTime()) && (trainArrivalB.getTime() <= arrivalB.getTime())) {
                        trains.add(train);
                    }
                }
            }
        }
        return trains;
    }
}
