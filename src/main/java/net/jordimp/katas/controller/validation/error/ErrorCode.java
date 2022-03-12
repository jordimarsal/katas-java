package net.jordimp.katas.controller.validation.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    /**
     * Thrown when illegal Kata error occurs.
     */
    KATA_NOT_FOUND("KAT-0001"),
    KATA_ALREADY_EXISTS("KAT-0002"),
    KATA_NAME_MISSING("KAT-0003"),
    KATA_NAME_TOO_LONG("KAT-0004"),
    KATA_NAME_INVALID("KAT-0005"),
    USER_NOT_FOUND("USR-0001"),

    /**
     * Thrown when illegal User error occurs.
     */
    USER_ALREADY_EXISTS("USR-0002"),
    USER_NAME_MISSING("USR-0003"),
    USER_NAME_TOO_LONG("USR-0004"),
    USER_NAME_INVALID("USR-0005"),
    USER_PASSWORD_MISSING("USR-0006"),
    USER_PASSWORD_TOO_LONG("USR-0007"),
    USER_PASSWORD_INVALID("USR-0008"),
    USER_EMAIL_MISSING("USR-0009"),
    USER_EMAIL_TOO_LONG("USR-0010"),
    USER_EMAIL_INVALID("USR-0011"),
    USER_PASSWORD_MISMATCH("USR-0012"),

    /**
     * Thrown when an illegal Validation error occurs.
     */
    VALIDATION_FAILS("VAL-0001"),


    /**
     * Thrown when an illegal argument error occurs.
     */
    ILLEGAL_ARGUMENT("ERR-9998"),

    /**
     * Thrown when the error has not been captured by any specific exception.
     */
    UNKNOWN("ERR-9999");

    private final String code;

}
