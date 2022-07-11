package com.pinapp.people.usecase.mapper;

import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.repository.dao.PeopleDao;
import com.pinapp.people.usecase.model.People;
import com.pinapp.people.usecase.model.PeopleExtend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring", imports = {Period.class, LocalDate.class})
public interface ModelMapper {

    People mapPeopleDaoToPeople(PeopleDao peopleDao);

    @Mapping(target = "deceaseDate", expression = "java(peopleDao.getBirthdate().plusYears(80L))")
    @Mapping(target = "age", expression = "java(Period.between(peopleDao.getBirthdate(),LocalDate.now()).getYears())")
    PeopleExtend mapPeopleDaoToPeopleExtend(PeopleDao peopleDao);

    PeopleDao mapClientDtoToPeopleDao(ClientDto clientDto);
}
