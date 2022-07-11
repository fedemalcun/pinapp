package com.pinapp.people.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "All Clients Media View DTO", name = "AllClientsMediaViewDto", description = "All Clients Media And Deviation")
public class AllClientsMediaViewDto {

    @Schema(description = "Clients Media", implementation = Float.class)
    private float Media;

    @Schema(description = "Clients Deviation", implementation = Double.class)
    private Double StandardDeviation;
}
