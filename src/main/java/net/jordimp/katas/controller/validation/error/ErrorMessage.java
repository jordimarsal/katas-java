package net.jordimp.katas.controller.validation.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

    private final String errorCode;
    private final String errorMessage;
}
