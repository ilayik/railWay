package com.example.sweater.repo;

import com.example.sweater.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train, Long> {

}
