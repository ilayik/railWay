package com.example.sweater.controllers;

import com.example.sweater.modul.Passenger;
import com.example.sweater.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class PassengerController {
    @Autowired
    private PassengerRepo passengerRepo;


    @GetMapping("/passenger")
    public String showAllPassenger(Model model){
        Iterable<Passenger> allPassengers = passengerRepo.findAll();
        model.addAttribute("allPassengersList", allPassengers);
        return "passengers/passenger";
    }

    @PostMapping("/passenger")
    public String PostPassengers(@RequestParam (name = "PassengerName") String PassengerName,
                                 @RequestParam (name = "PassengerSurName") String PassengerSurName,
                                 @RequestParam (name = "PassengerDataBirth") String PassengerDataBirth,
                                 Model model)  {
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(PassengerDataBirth);
            Passenger newPassenger = new Passenger(PassengerName,PassengerSurName,date);
            passengerRepo.save(newPassenger);
        }catch (Exception e){
            System.out.println(e);
        }
        Iterable<Passenger> allPassengers = passengerRepo.findAll();
        model.addAttribute("allPassengersList", allPassengers);
        return "passengers/passenger";
    }
}