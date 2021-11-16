package net.jordimp.katas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.service.UserService;

@RestController
@RequestMapping(value = "/katas", method = { RequestMethod.POST, RequestMethod.GET })
public class KataRestController {

    private final UserService userService;

    public KataRestController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String root() {
        return "Endpoints:<br>----------------<br><br>/ this page <br> <br>\n/katas/ <br>\n/katas/{name}<br>/katas-by-language/Jordi<br><br>";
    }

    @GetMapping(value = "/katas")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/katas/{name}")
    public UserDto getUserByUserName(@PathVariable(value = "name") final String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping(value = "/katas-by-language/{language}")
    public List<UserDto> getUsersByFirstName(@PathVariable(value = "language") final String firstName) {
        return this.userService.getUsersByFirstname(firstName);
    }

}
