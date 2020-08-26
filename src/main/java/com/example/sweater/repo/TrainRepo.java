package com.example.sweater.repo;

import com.example.sweater.modul.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends CrudRepository<Train, Integer> {
}
