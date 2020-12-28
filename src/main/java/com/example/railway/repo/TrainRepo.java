package com.example.railway.repo;

import com.example.railway.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train, Long> {

}
