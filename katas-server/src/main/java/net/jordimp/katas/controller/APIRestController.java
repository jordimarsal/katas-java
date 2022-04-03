package net.jordimp.katas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.jordimp.katas.dto.Balance;

/**
 * APIRestController provides a REST API for the APIRestController.
 *
 * @author: Jordi Marsal.
 *
 */
@Tag(name = "APIRestController",
    description = "This is the main controller for getting APIRestController' Information")
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class APIRestController {

    /**
     * Get balance.
     *
     * @return Balance.
     */
    @GetMapping(value = "/phone_numbers/{phone_number}/balance")
    public Balance getBalance(@PathVariable(value = "phone_number") final String phone) {
        return Balance.builder()
            .currency("EUR")
            .amount(25.15)
            .phone_number(phone)
            .expiration_date("2023-01-01T00:00:00Z")
            .build();
    }

}
