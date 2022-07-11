package com.pinapp.people.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "All Clients Media View DTO", name = "ClientViewExtendDto", description = "Clients Extend DTO")
public class ClientViewExtendDto extends ClientViewDto {

    @Schema(description = "Client's birthdate", implementation = LocalDate.class)
    private LocalDate deceaseDate;
}
