package com.pinapp.people.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinapp.people.controller.dto.ClientDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PeopleControllerTest {

    private MockMvc mockMvc;
    private ClientDto clientDto;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private PeopleControllerImpl transactionController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController)
                .build();
        clientDto = new ClientDto();
    }

    @DisplayName("Save Client Test Fail - Null")
    @SneakyThrows
    @Test
    void testCreateClientFailNull() {
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(null))).andExpect(status().isBadRequest());
    }

    @DisplayName("Save Client Test Fail - Birthdate Null")
    @SneakyThrows
    @Test
    void testCreateClientFailBirthdateNull() {
        clientDto.setName("Federico");
        clientDto.setLastname("Federico");
        clientDto.setAge(11);
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(clientDto))).andExpect(status().isBadRequest());
    }

    @DisplayName("Save Client Test Fail - Age Null")
    @SneakyThrows
    @Test
    void testCreateClientFailAgeNull() {
        clientDto.setName("Federico");
        clientDto.setLastname("Federico");
        clientDto.setBirthdate(LocalDate.now());
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(clientDto))).andExpect(status().isBadRequest());
    }

    @DisplayName("Save Client Test Fail - Name Null")
    @SneakyThrows
    @Test
    void testCreateClientFailNameNull() {
        clientDto.setLastname("Federico");
        clientDto.setAge(11);
        clientDto.setBirthdate(LocalDate.now());
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(clientDto))).andExpect(status().isBadRequest());
    }

    @DisplayName("Save Client Test Fail - Lastname Null")
    @SneakyThrows
    @Test
    void testCreateClientFailLastnameNull() {
        clientDto.setName("Federico");
        clientDto.setAge(11);
        clientDto.setBirthdate(LocalDate.now());
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(clientDto))).andExpect(status().isBadRequest());
    }

    @DisplayName("Save Client Test Success")
    @SneakyThrows
    @Test
    void testCreateClientSuccess() {
        clientDto.setName("Federico");
        clientDto.setLastname("Federico");
        clientDto.setAge(11);
        clientDto.setBirthdate(LocalDate.now());
        mockMvc.perform(post("/pinapp/people/crearcliente/").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(clientDto))).andExpect(status().isCreated());
    }

    @DisplayName("Get All Clients")
    @SneakyThrows
    @Test
    void testGetAllClientsSuccess() {;
        mockMvc.perform(get("/pinapp/people/listclients/")).andExpect(status().isOk());
    }

    @DisplayName("Get all clients media and standard deviation")
    @SneakyThrows
    @Test
    void testGetAllClientsMediaSuccess() {;
        mockMvc.perform(get("/pinapp/media/kpideclientes/")).andExpect(status().isOk());
    }

}
