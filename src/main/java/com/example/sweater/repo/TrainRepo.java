package com.example.sweater.repo;

import com.example.sweater.modul.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train, Integer> {
}
