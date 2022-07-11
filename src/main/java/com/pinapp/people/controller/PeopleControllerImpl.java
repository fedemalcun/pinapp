package com.pinapp.people.controller;

import com.pinapp.people.controller.dto.AllClientsMediaViewDto;
import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.controller.dto.ClientViewDto;
import com.pinapp.people.controller.dto.ClientViewExtendDto;
import com.pinapp.people.controller.mapper.DtoMapper;
import com.pinapp.people.usecase.PeopleUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PeopleControllerImpl implements PeopleController{

    private final PeopleUsecase peopleUsecase;
    private final DtoMapper mapper;

    @Override
    public ClientViewDto createClient(ClientDto clientDto) {
        return mapper.mapPeopleToClientViewDto(peopleUsecase.saveClient(clientDto));
    }

    @Override
    public AllClientsMediaViewDto getAllClientsMedia() {
        return mapper.mapMediaToAllClientsMedia(peopleUsecase.getMediaAndDeviation());
    }

    @Override
    public List<ClientViewExtendDto> getAllClients() {
        return mapper.mapPeopleToClientViewExtendDto(peopleUsecase.getAllClients());
    }

}
