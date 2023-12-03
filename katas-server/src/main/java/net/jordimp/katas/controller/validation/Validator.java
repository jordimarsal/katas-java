package net.jordimp.katas.controller.validation;

import static java.lang.String.format;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validateParams(final String key, final String userName, final String firstName, final String lastName) {
        this.validateKey(key);
        this.validatePathString(userName, "username");
        this.validatePathString(firstName, "firstName");
        this.validatePathString(lastName, "lastName");
    }

    public void validatePathStringToLong(final String longPath) {

        this.validatePathString(longPath,"longPath");
        final String regEx = "[0-9]+";
        if (!longPath.matches(regEx)) {
            throw new IllegalArgumentException("Parameter must be only numbers greater than zero.");
        }
    }

    public void validatePathString(String stringPath, final String paramName) {

        if (stringPath != null) {
            stringPath = stringPath.strip();
        }

        if (stringPath == null || stringPath.isEmpty()) {
            throw new IllegalArgumentException(format("Parameter '%s' cannot be null, empty, nor space.", paramName));
        }
    }

    public void validateKey(final String key) {
        if (!key.equals("Magic_Key")) {
            throw new IllegalArgumentException("Invalid key");
        }
    }
}
