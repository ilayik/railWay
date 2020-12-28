package com.example.sweater.repo;

import com.example.sweater.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<Station, Long> {
}
