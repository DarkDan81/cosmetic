package com.costetics.backend.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserSummary {
    private String mail;
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    private String city;
}