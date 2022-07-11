package com.pinapp.people.controller;

import com.pinapp.people.controller.dto.AllClientsMediaViewDto;
import com.pinapp.people.controller.dto.ClientDto;
import com.pinapp.people.controller.dto.ClientViewDto;
import com.pinapp.people.controller.dto.ClientViewExtendDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/pinapp")
@Tag(name = "pinApp", description = "PinApp People")
public interface PeopleController {

    @PostMapping(path = "/people/crearcliente")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create client", summary = "Create client")
    ClientViewDto createClient(@Valid @RequestBody ClientDto clientDto);

    @GetMapping(path = "/media/kpideclientes")
    @Operation(description = "Get all clients media and standard deviation", summary = "Get all clients media and standard deviation")
    AllClientsMediaViewDto getAllClientsMedia();

    @GetMapping(path = "/people/listclients")
    @Operation(description = "Get all clients", summary = "Get all clients")
    List<ClientViewExtendDto> getAllClients();

}
