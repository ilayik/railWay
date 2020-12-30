package com.example.railway.service;

import com.example.railway.dto.TicketDTO;
import com.example.railway.model.Ticket;
import com.example.railway.model.Train;
import com.example.railway.model.User;
import com.example.railway.repo.TicketRepo;
import com.example.railway.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;
    private final UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepo ticketRepo, UserRepository userRepository) {
        this.ticketRepo = ticketRepo;
        this.userRepository = userRepository;
    }

    public Ticket addTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        User userByLogin = userRepository.findByLogin(ticketDTO.getUserLogin()).orElse(null);
        ticket.setUser(userByLogin);
        ticket.setTrain(ticketDTO.getTrain());
        return ticketRepo.save(ticket);
    }

    public Iterable<Ticket> getTickets() {
        return ticketRepo.findAll();
    }

    public int ticketUserCheck(TicketDTO ticketDTO) {
        User user = userRepository.findByLogin(ticketDTO.getUserLogin()).orElse(null);
        Train train = ticketDTO.getTrain();
        // 0 - нет проблем , 1 - на поезде нет мест, 2 - уже есть билет на этот поезд
        int ticketCheck = 0;
        if (Integer.parseInt(train.getCapacity()) <= 0) {
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
