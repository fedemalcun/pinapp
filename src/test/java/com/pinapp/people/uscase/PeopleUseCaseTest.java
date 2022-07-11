package com.pinapp.people.uscase;

import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.repository.PeopleRepository;
import com.pinapp.people.repository.dao.PeopleDao;
import com.pinapp.people.usecase.PeopleUsecase;
import com.pinapp.people.usecase.PeopleUsecaseImpl;
import com.pinapp.people.usecase.mapper.ModelMapper;
import com.pinapp.people.usecase.model.Media;
import com.pinapp.people.usecase.model.People;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeopleUseCaseTest {

    private PeopleUsecase peopleUsecase;
    private List<PeopleDao> peopleDaoList;

    @Mock
    private PeopleRepository peopleRepository;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setup(){
        peopleUsecase = new PeopleUsecaseImpl(peopleRepository, mapper);
        peopleDaoList = new ArrayList<>();
    }

    @Test
    void testSaveClient(){
        ClientDto clientDto = new ClientDto();
        clientDto.setLastname("sarasa");
        clientDto.setName("sarasa");
        clientDto.setBirthdate(LocalDate.of(1990,01,01));

        People people = new People();
        people.setLastname("sarasa");
        people.setName("sarasa");
        people.setBirthdate(LocalDate.of(1990,01,01));

        PeopleDao peopleDao = new PeopleDao();
        peopleDao.setLastname("sarasa");
        peopleDao.setName("sarasa");
        peopleDao.setBirthdate(LocalDate.of(1990,01,01));
        when(peopleRepository.save(peopleDao)).thenReturn(peopleDao);
        when(mapper.mapClientDtoToPeopleDao(clientDto)).thenReturn(peopleDao);
        when(mapper.mapPeopleDaoToPeople(peopleDao)).thenReturn(people);
        People response = peopleUsecase.saveClient(clientDto);

        assertEquals(peopleDao.getName(), response.getName());
        assertEquals(peopleDao.getLastname(), response.getLastname());
        assertEquals(peopleDao.getBirthdate(), response.getBirthdate());

        verify(peopleRepository, times(1)).save(peopleDao);
        verify(mapper, times(1)).mapClientDtoToPeopleDao(clientDto);
        verify(mapper, times(1)).mapPeopleDaoToPeople(peopleDao);
    }

    @Test
    void testGetMediaAndDeviation(){
        PeopleDao peopleDao = new PeopleDao();
        peopleDao.setLastname("sarasa");
        peopleDao.setName("sarasa");
        peopleDao.setBirthdate(LocalDate.of(1990,01,01));
        PeopleDao peopleDao_1 = new PeopleDao();
        peopleDao_1.setLastname("sarasa");
        peopleDao_1.setName("sarasa");
        peopleDao_1.setBirthdate(LocalDate.of(1990,01,01));
        PeopleDao peopleDao_2 = new PeopleDao();
        peopleDao_2.setLastname("sarasa");
        peopleDao_2.setName("sarasa");
        peopleDao_2.setBirthdate(LocalDate.of(1990,01,01));
        peopleDaoList.add(peopleDao);
        peopleDaoList.add(peopleDao_1);
        peopleDaoList.add(peopleDao_2);
        when(peopleRepository.findAll()).thenReturn(peopleDaoList);
        Media media = peopleUsecase.getMediaAndDeviation();

        assertEquals(32, media.getMedia());
        assertEquals(0.0, media.getStandardDeviation());

        verify(peopleRepository, times(1)).findAll();
    }
}
