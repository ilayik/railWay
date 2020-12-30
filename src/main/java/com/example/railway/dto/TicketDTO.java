package com.example.railway.dto;

import com.example.railway.model.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private String userLogin;
    private Train train;
}
