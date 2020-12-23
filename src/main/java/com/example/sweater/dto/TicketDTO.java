package com.example.sweater.dto;

import com.example.sweater.model.Train;
import com.example.sweater.model.User;
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
