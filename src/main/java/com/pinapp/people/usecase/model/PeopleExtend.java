package com.pinapp.people.usecase.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class PeopleExtend extends People{

    private LocalDate deceaseDate;
}
