package com.github.solairerove.harald.application;

import com.github.solairerove.harald.application.dto.ErrorResponse;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Exception handler component.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle exception when intended handler are not found.
     *
     * @param exception an exception
     * @return an error message
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResponseEntity handleAnException(final Exception exception) {
        final UUID errorUUID = UUID.randomUUID();

        log.error("Error-ID: {} - {}", errorUUID, exception.getMessage(), exception);

        final String message = "An error occurred. Please contact support. Error-ID:" + errorUUID;

        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.aErrorResponse(INTERNAL_SERVER_ERROR.value(), message));
    }

    /**
     * Handle {@link ResourceNotFoundException}.
     *
     * @param exception an exception
     * @return an error message
     */
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseBody
    public ResponseEntity handleResourceNotFoundException(final ResourceNotFoundException exception) {
        final String message = exception.getMessage();

        log.warn("Caught ResourceNotFoundException: {}", message);

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ErrorResponse.aErrorResponse(BAD_REQUEST.value(), message));
    }
}
