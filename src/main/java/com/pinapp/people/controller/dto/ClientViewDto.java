package com.pinapp.people.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(title = "Client View DTO", name = "ClientViewDto", description = "Client info saved")
public class ClientViewDto {

    @Schema(description = "Client's name", implementation = String.class)
    private String name;

    @Schema(description = "Client's lastname", implementation = String.class)
    private String lastname;

    @Schema(description = "Client's age", implementation = Integer.class)
    private int age;

    @Schema(description = "Client's birthdate", implementation = LocalDate.class, pattern = "YYYY-mm-dd")
    private LocalDate birthdate;
}
