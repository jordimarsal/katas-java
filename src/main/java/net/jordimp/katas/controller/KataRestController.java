package net.jordimp.katas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.service.KataService;

/**
 * KataRestController provides a REST API for the KataService.
 *
 * @author Jordi Marsal
 *
 */
@Tag(name = "KataRestController",
    description = "This is the main controller for getting Katas' Information")
@RestController
@RequestMapping(value = "/katas")
public class KataRestController {

    private static final String BR = "<br><br>";

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

    @Value("${server.port}")
    private int serverPort;

    /**
     * Information endpoint.
     *
     * @return endpoints.
     */
    // @formatter:off
    @Operation(description = "RootInfo", summary = "This endpoint get Info for endpoints",
        security = {@SecurityRequirement(name = "Authorization")})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
            description = "Successful operation",
            content = @Content(mediaType = "text/html", schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "x-error",
            description = "Failed operation",
            content = @Content(
                examples = {@ExampleObject(name = "INF-0002",
                    description = "Thrown when trying to get endpoints info.",
                    value = "{\"errorCode\":\"INF-0002\",\"errorMessage\":\"Info unavailable.\"}"),
                },
                mediaType = "application/json"))
    })
    // @formatter:on
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String root() {
        // @formatter:off
        return "<html>"
               + "Endpoints:<br>----------------<br>"
               + "<br>" + this.link("/katas") + " this page" + BR
               + "\n/katas/{name} -> " + this.link("/katas/guest") + BR
               + this.link("/katas/by-language/Java") + BR
               + "API: " + this.link("/swagger-ui.html") + BR
               + "API: " + this.link("/v3/api-docs/")
               + "<br></html>";
        // @formatter:on
    }

    private String stem() {
        return "http://localhost:" + this.serverPort;
    }

    private String link(final String suffix) {
        return "<a href=\"" + this.stem() + suffix + "\">" + suffix + "</a>";
    }

    /**
     * Get all katas.
     *
     * @return List of katas.
     */
    @GetMapping(value = "/all")
    public List<KataDto> getKatas() {
        return this.kataService.getAllKatas();
    }

    /**
     * Get kata by name.
     *
     * @param name kata name.
     * @return kata.
     */
    @GetMapping(value = "/{name}")
    public KataDto getKataByName(@PathVariable(value = "name") final String name) {
        return this.kataService.getKataByName(name);
    }

    /**
     * Get kata by language.
     *
     * @param language kata language.
     * @return List of katas.
     */
    @GetMapping(value = "/by-language/{language}")
    public List<KataDto> getKatasByLanguage(@PathVariable(value = "language") final String language) {
        return this.kataService.getKatasByLanguage(language);
    }

}
