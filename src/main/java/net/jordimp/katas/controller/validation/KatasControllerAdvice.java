package net.jordimp.katas.controller.validation;

import static net.jordimp.katas.controller.validation.error.ErrorCode.ILLEGAL_ARGUMENT;
import static net.jordimp.katas.controller.validation.error.ErrorCode.KATA_NOT_FOUND;
import static net.jordimp.katas.controller.validation.error.ErrorCode.UNKNOWN;
import static net.jordimp.katas.controller.validation.error.ErrorCode.USER_NOT_FOUND;
import static net.jordimp.katas.controller.validation.error.ErrorCode.VALIDATION_FAILS;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import net.jordimp.katas.controller.KataRestController;
import net.jordimp.katas.controller.UserRestController;
import net.jordimp.katas.controller.validation.error.ErrorCode;
import net.jordimp.katas.controller.validation.error.ErrorMessage;
import net.jordimp.katas.controller.validation.error.ErrorResponse;
import net.jordimp.katas.controller.validation.exception.KataNotFoundException;
import net.jordimp.katas.controller.validation.exception.UserNotFoundException;

@Slf4j
@Order(0)
@RestControllerAdvice(assignableTypes = { KataRestController.class, UserRestController.class })
public class KatasControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(final KataNotFoundException cause) {
        return new ErrorResponse(KATA_NOT_FOUND, cause.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(final UserNotFoundException cause) {
        return new ErrorResponse(USER_NOT_FOUND, cause.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorMessage handle(final MethodArgumentNotValidException exception) {
        final String message = this.buildValidationMessage(exception.getBindingResult().getAllErrors());
        return this.buildErrorMessage(VALIDATION_FAILS, message);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ErrorMessage handle(final Throwable exception) {
        log.error("Caught exception", exception);
        return this.buildErrorMessage(UNKNOWN, exception);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ErrorMessage handle(final IllegalArgumentException exception) {
        log.error("Caught exception", exception);
        return this.buildErrorMessage(ILLEGAL_ARGUMENT, exception);
    }

    private String buildValidationMessage(final List<ObjectError> errors) {
        return errors.stream() // @formatter:off
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.joining("|")); // @formatter:on
    }

    private ErrorMessage buildErrorMessage(final ErrorCode errorCode, final String message) {
        return ErrorMessage.builder().errorCode(errorCode.getCode()).errorMessage(message).build();
    }

    private ErrorMessage buildErrorMessage(final ErrorCode errorCode, final Throwable t) {
        return this.buildErrorMessage(errorCode, t.getMessage());
    }

}
