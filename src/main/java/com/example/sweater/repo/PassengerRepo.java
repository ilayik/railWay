package com.example.sweater.repo;

import com.example.sweater.modul.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends CrudRepository<Passenger, Integer> {


}
