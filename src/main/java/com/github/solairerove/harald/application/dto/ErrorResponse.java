package com.github.solairerove.harald.application.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * Error entity.
 */
@Value(staticConstructor = "aErrorResponse")
public final class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 5132481321950500416L;

    private final int status;
    private final String message;
}
