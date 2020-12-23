package com.example.sweater.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}