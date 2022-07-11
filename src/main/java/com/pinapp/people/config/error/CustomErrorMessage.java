package com.pinapp.people.config.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorMessage {

    @Schema(description = "Error description", example = "BAD REQUEST")
    private String description;

    @Schema(description = "Error code", example = "400")
    private String errorCode;

}
