package com.pinapp.people.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Schema(title = "Clientno DTO", name = "ClientDto", description = "Client info to save")
public class ClientDto {

    @Schema(description = "Client's name", implementation = String.class)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Schema(description = "Client's lastname", implementation = String.class)
    @NotNull(message = "Lastname is mandatory")
    private String lastname;

    @Schema(description = "Client's age", implementation = Integer.class)
    @NotNull(message = "Age is mandatory")
    private Integer age;

    @Schema(description = "Client's birthdate", implementation = LocalDate.class, pattern = "YYYY-mm-dd")
    @NotNull(message = "Name is mandatory")
    private LocalDate birthdate;
}
