package net.jordimp.katas.controller.validation.exception;

public class KataNotFoundException extends RuntimeException {

    public KataNotFoundException(String message) {
        super(message);
    }

}
