package net.jordimp.katas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.service.KataService;

/**
 * KataRestController provides a REST API for the KataService.
 *
 * @author Jordi Marsal
 *
 */

@RestController
@RequestMapping(value = "/katas", method = { RequestMethod.POST, RequestMethod.GET })
public class KataRestController {

    /**
     * KataService instance.
     */
    private final KataService kataService;

    /**
     * Constructor.
     *
     * @param kataService KataService instance.
     */
    public KataRestController(final KataService kataService) {
        this.kataService = kataService;
    }

    /**
     * Information endpoint.
     *
     * @return endpoints.
     */
    @GetMapping
    public String root() {
        return "Endpoints:<br>----------------<br><br>/ this page <br> <br>\n/katas/ <br>\n/katas/{name}<br>/katas-by-language/Java<br><br>";
    }

    /**
     * Get all katas.
     *
     * @return List of katas.
     */
    @GetMapping(value = "/katas")
    public List<KataDto> getKatas() {
        return this.kataService.getAllKatas();
    }

    /**
     * Get kata by name.
     *
     * @param name kata name.
     * @return kata.
     */
    @GetMapping(value = "/katas/{name}")
    public KataDto getKataByName(@PathVariable(value = "name") final String name) {
        return this.kataService.getKataByName(name);
    }

    /**
     * Get kata by language.
     *
     * @param language kata language.
     * @return List of katas.
     */
    @GetMapping(value = "/katas-by-language/{language}")
    public List<KataDto> getKatasByLanguage(@PathVariable(value = "language") final String language) {
        return this.kataService.getKatasByLanguage(language);
    }

}
