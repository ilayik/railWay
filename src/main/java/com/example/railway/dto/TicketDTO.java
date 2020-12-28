package com.example.railway.dto;

import com.example.railway.model.Train;
import com.example.railway.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private User user;
    private Train train;

}
