package com.example.sweater.service;

import com.example.sweater.modul.Passenger;
import com.example.sweater.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepo passengerRepo;

    public Iterable<Passenger> getAllPassenger(){
        return passengerRepo.findAll();
    }

    public void addPassenger (String name, String surname, String birthdate) throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(birthdate);
        Passenger newPassenger = new Passenger(name, surname, date);
        passengerRepo.save(newPassenger);
    }


}
