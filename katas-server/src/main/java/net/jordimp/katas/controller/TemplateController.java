package net.jordimp.katas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class TemplateController {

    @GetMapping(value = "/")
    public String index(final Model model) {
        return "index";
    }

}
