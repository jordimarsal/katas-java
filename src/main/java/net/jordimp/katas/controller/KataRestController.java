package net.jordimp.katas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.service.KataService;

@RestController
@RequestMapping(value = "/katas", method = { RequestMethod.POST, RequestMethod.GET })
public class KataRestController {

    private final KataService kataService;

    public KataRestController(final KataService kataService) {
        this.kataService = kataService;
    }

    @GetMapping
    public String root() {
        return "Endpoints:<br>----------------<br><br>/ this page <br> <br>\n/katas/ <br>\n/katas/{name}<br>/katas-by-language/Java<br><br>";
    }

    @GetMapping(value = "/katas")
    public List<KataDto> getKatas() {
        return this.kataService.getAllKatas();
    }

    @GetMapping(value = "/katas/{name}")
    public KataDto getKataByName(@PathVariable(value = "name") final String name) {
        return this.kataService.getKataByName(name);
    }

    @GetMapping(value = "/katas-by-language/{language}")
    public List<KataDto> getKatasByLanguage(@PathVariable(value = "language") final String language) {
        return this.kataService.getKatasByLanguage(language);
    }

}
