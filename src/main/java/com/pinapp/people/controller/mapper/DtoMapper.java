package com.pinapp.people.controller.mapper;

import com.pinapp.people.controller.dto.AllClientsMediaViewDto;
import com.pinapp.people.controller.dto.ClientViewDto;
import com.pinapp.people.controller.dto.ClientViewExtendDto;
import com.pinapp.people.usecase.model.Media;
import com.pinapp.people.usecase.model.People;
import com.pinapp.people.usecase.model.PeopleExtend;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    ClientViewDto mapPeopleToClientViewDto(People people);
    AllClientsMediaViewDto mapMediaToAllClientsMedia(Media media);
    List<ClientViewExtendDto> mapPeopleToClientViewExtendDto(List<PeopleExtend> peopleList);
}
