package com.example.railway.service;

import com.example.railway.model.Ticket;
import com.example.railway.model.Train;
import com.example.railway.model.User;
import com.example.railway.dto.TicketDTO;
import com.example.railway.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket addTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setUser(ticketDTO.getUser());
        ticket.setTrain(ticketDTO.getTrain());
        return ticketRepo.save(ticket);
    }

    public Iterable<Ticket> getTickets() {
        return ticketRepo.findAll();
    }

    public int ticketUserCheck(TicketDTO ticketDTO) {
        User user = ticketDTO.getUser();
        Train train = ticketDTO.getTrain();
        // 0 - нет проблем , 1 - на поезде нет мест, 2 - уже есть билет на этот поезд
        int ticketCheck = 0;
        if (Integer.parseInt(train.getCapacity())<=0) {
            ticketCheck = 1;
        }
        for (Ticket ticket : getTickets()) {
            if ((ticket.getUser().getId().equals(user.getId())) && (ticket.getTrain().getId().equals(train.getId()))) {
                ticketCheck = 2;
                break;
            }
        }
        return ticketCheck;
    }

    public List<User> getUsersByTrainNumber(String trainNumber) {
        String n = trainNumber.split(" ")[1];
        List<User> userList = new ArrayList<>();
        for (Ticket ticket : getTickets()) {
            if (ticket.getTrain().getNumber().equals(n)) {
                userList.add(ticket.getUser());
            }
        }
        return userList;
    }

}
