package com.example.railway.controller;

import com.example.railway.model.Ticket;
import com.example.railway.dto.TicketDTO;
import com.example.railway.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('read')")
    public Ticket addTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.addTicket(ticketDTO);
    }

    @PostMapping("/user-check")
    @PreAuthorize("hasAuthority('read')")
    public int userCheck(@RequestBody TicketDTO ticketDTO) {
        return ticketService.ticketUserCheck(ticketDTO);
    }

}

