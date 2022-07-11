package com.pinapp.people.usecase;

import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.exception.noClientsException;
import com.pinapp.people.repository.PeopleRepository;
import com.pinapp.people.repository.dao.PeopleDao;
import com.pinapp.people.usecase.mapper.ModelMapper;
import com.pinapp.people.usecase.model.Media;
import com.pinapp.people.usecase.model.People;
import com.pinapp.people.usecase.model.PeopleExtend;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PeopleUsecaseImpl implements PeopleUsecase{

    private final PeopleRepository peopleRepository;
    private final ModelMapper mapper;

    @Override
    public People saveClient(ClientDto clientDto) {
        log.info("Saving Client...");
        return mapper.mapPeopleDaoToPeople(peopleRepository.save(mapper.mapClientDtoToPeopleDao(clientDto)));
    }

    @Override
    public Media getMediaAndDeviation() {
        List<PeopleDao> peopleDaoList = peopleRepository.findAll();
        float average = this.getMedia(peopleDaoList);
        Media media = new Media();
        media.setMedia(average);
        media.setStandardDeviation(this.getDeviation(peopleDaoList, average));
        return media;
    }

    @Override
    public List<PeopleExtend> getAllClients() {
        log.info("Getting All Clients...");
        return peopleRepository.findAll().stream().map(mapper::mapPeopleDaoToPeopleExtend).collect(Collectors.toList());
    }

    private int getAge(LocalDate birthdate){
        log.info("Getting Age...");
        return Period.between(birthdate,LocalDate.now()).getYears();
    }

    private float getMedia(List<PeopleDao> list){
        log.info("Getting Media...");
        int totalAge = list.stream().mapToInt(peopleDao -> this.getAge(peopleDao.getBirthdate())).sum();
        return (float) (totalAge/list.size());
    }

    private double getDeviation(List<PeopleDao> list, float media){
        log.info("Getting Deviation...");
        double variation = list.stream().mapToDouble(peopleDao -> Math.pow(this.getAge(peopleDao.getBirthdate()) - media, 2f)).sum();
        variation = variation / list.size();
        return Math.sqrt(variation);
    }
}
