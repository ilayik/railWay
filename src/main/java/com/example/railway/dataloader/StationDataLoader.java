package com.example.railway.dataloader;

import com.example.railway.model.Station;
import com.example.railway.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StationDataLoader implements ApplicationRunner {

    private final StationRepo stationRepo;

    @Autowired
    public StationDataLoader(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        stationRepo.save(new Station(1L,"Station1",null));
        stationRepo.save(new Station(2L,"Station2",null));
        stationRepo.save(new Station(3L,"Station3",null));
        stationRepo.save(new Station(4L,"Station4",null));
        stationRepo.save(new Station(4L,"Station5",null));
        stationRepo.save(new Station(4L,"Station6",null));
        stationRepo.save(new Station(4L,"Station7",null));
    }
}
