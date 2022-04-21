package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {
    private String userName;
    private LocalDateTime registeredDateAndTime;
    private UserType userType;
}
