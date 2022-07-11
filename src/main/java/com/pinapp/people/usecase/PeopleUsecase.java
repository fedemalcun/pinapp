package com.pinapp.people.usecase;

import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.usecase.model.Media;
import com.pinapp.people.usecase.model.People;
import com.pinapp.people.usecase.model.PeopleExtend;

import java.util.List;

public interface PeopleUsecase {

    People saveClient(ClientDto clientDto);

    Media getMediaAndDeviation();

    List<PeopleExtend> getAllClients();
}
