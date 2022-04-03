package net.jordimp.katas.controller.validation.error;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse {

    public static final String DEFAULT_ERROR_CODE = "ERR-0001";
    public static final String DEFAULT_ERROR_MESSAGE = "No error message found";

    @Schema(description = "Error code", example = DEFAULT_ERROR_CODE)
    private final String errorCode;
    @Schema(description = "Error message", example = DEFAULT_ERROR_MESSAGE)
    private final String errorMessage;

    public ErrorResponse(final String errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorResponse(final String errorMessage) {
        this(DEFAULT_ERROR_CODE, errorMessage);
    }

    public ErrorResponse(final ErrorCode errorCode, final String message) {
        this(errorCode.getCode(), message);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        final ErrorResponse other = (ErrorResponse) obj;
        if (this.errorCode == null) {
            return other.errorCode == null;
        } else
            return this.errorCode.equals(other.errorCode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((errorCode == null) ? 0 : errorCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getErrorCode(), this.getErrorMessage());
    }
}
