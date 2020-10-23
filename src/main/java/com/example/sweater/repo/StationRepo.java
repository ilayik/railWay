package com.example.sweater.repo;

import com.example.sweater.modul.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {
}
