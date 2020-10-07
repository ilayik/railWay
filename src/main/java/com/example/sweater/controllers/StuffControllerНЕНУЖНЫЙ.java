package com.example.sweater.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StuffControllerНЕНУЖНЫЙ {


    @GetMapping("/stuff")
    public String stuffPage() {
        return "stuff/stuff";
    }



    @GetMapping("/lookPassTrain")
    public String lookPassTrainPage() {
        return "stuff/lookPassTrain";
    }


}
