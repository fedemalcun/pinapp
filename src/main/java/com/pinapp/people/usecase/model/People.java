package com.pinapp.people.usecase.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class People {

    private String name;
    private String lastname;
    private int age;
    private LocalDate birthdate;
}
