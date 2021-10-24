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
@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
public class UserRestController {

    private final UserService userService;

    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String root() {
        return "Endpoints:<br>----------------<br><br>/ this page <br> <br>\n/users/ <br>\n/users/{username}<br><br>*guest is an username";
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/users/{username}")
    public UserDto getUserByUserName(@PathVariable(value = "username") final String username) {
        return this.userService.getUserByUsername(username);
    }

}
