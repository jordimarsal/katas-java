package net.jordimp.katas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TemplateController {

    @Value("${server.port}")
    private int serverPort;

    private static final String BR = "<br><br>";

    @GetMapping(value = "/")
    public String index(final Model model) {
        // this attribute will be available in the view index.html as a thymeleaf variable
        model.addAttribute("eventName", getEndpoints());
        // this just means render index.html from static/ area
        return "index";
    }

    private String getEndpoints() {
        // @formatter:off
        return this.stem() + " this page" + BR
               + this.link("/users/") + BR
               + "/users/{username} -> " + this.link("/users/guest") + BR
               + "/users/{username} -> Also update with PUT" + BR
               + this.link("/users-by-fname/Jordi") + BR
               + this.link("/katas") + BR
               + "API: " + this.link("/swagger-ui.html") + BR
               + "API: " + this.link("/v3/api-docs/");
        // @formatter:on
    }

    private String stem() {
        return "http://localhost:" + this.serverPort;
    }

    private String link(final String suffix) {
        return "<a href=\"" + this.stem() + suffix + "\">" + suffix + "</a>";
    }

}
