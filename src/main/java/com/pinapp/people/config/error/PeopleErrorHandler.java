package com.pinapp.people.config.error;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PeopleErrorHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses({@ApiResponse(
            description = "An error occurred, please try again later",
            responseCode = "500",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = CustomErrorMessage.class
                    )
            )}
    )})
    public ResponseEntity<CustomErrorMessage> defaultExceptionHandler(final Exception ex) {
        log.error("Could not complete request due to error", ex);
        log.warn("Please reconsider adding specific handler for: " + ex.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(new CustomErrorMessage(PeopleErrorHandler.ErrorCodes.GENERIC_ERROR.toString(), PeopleErrorHandler.ErrorCodes.GENERIC_ERROR.getDescription()));
    }

    public enum ErrorCodes {
        GENERIC_ERROR("An error occurred, please try again later"),
        BAD_REQUEST("Bad Request, please review it and try again"),
        UNAUTHORIZED("Unauthorized!"),
        NOT_FOUND("The resource requested could not be found"),
        BACKEND_ERROR("A backend error occurred, please try again later");

        private String description;

        ErrorCodes(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
