package com.example.sweater.controllers;

import com.example.sweater.modul.Train;
import com.example.sweater.service.PassengerService;
import com.example.sweater.service.ScheduleService;
import com.example.sweater.service.StationService;
import com.example.sweater.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;



    @GetMapping("/passenger")
    public String showAllPassenger(Model model){
        model.addAttribute("allPassengersList", passengerService.getAllPassenger());
        return "passengers/passenger";
    }


    @PostMapping("/passenger")
    public String PostPassengers(@RequestParam (name = "PassengerName") String PassengerName,
                                 @RequestParam (name = "PassengerSurName") String PassengerSurName,
                                 @RequestParam (name = "PassengerDataBirth") String PassengerDataBirth,
                                 Model model) throws ParseException {
        passengerService.addPassenger(PassengerName,PassengerSurName,PassengerDataBirth);
        model.addAttribute("allPassengersList", passengerService.getAllPassenger());
        return "passengers/passenger";
    }

    @GetMapping("/passengerPage")
    public String passengerPage(Model model){
        return "passengers/passengerPage";
    }






}