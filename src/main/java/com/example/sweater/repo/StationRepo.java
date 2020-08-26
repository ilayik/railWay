package com.example.sweater.repo;

import com.example.sweater.modul.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends CrudRepository<Station, Integer> {



}
