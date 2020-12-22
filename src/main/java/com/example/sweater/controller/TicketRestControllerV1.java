package com.example.sweater.controller;

import com.example.sweater.model.Ticket;
import com.example.sweater.model.TicketDTO;
import com.example.sweater.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/tickets")
public class TicketRestControllerV1 {

    private final TicketService ticketService;

    @Autowired
    public TicketRestControllerV1(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket addTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.addTicket(ticketDTO);
    }

    @PostMapping("/user-check")
    public int userCheck(@RequestBody TicketDTO ticketDTO) {
        return ticketService.ticketUserCheck(ticketDTO);
    }

}

