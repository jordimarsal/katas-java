package net.jordimp.katas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.service.UserService;

@RestController
@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final Validator validator;

    @GetMapping(value = "/")
    public String root() {
        return "Endpoints:<br>----------------<br><br>/ this page <br> <br>\n/users/ <br>\n/users/{username}<br>/users-by-fname/Jordi<br><br>*guest is an username";
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/users/{username}")
    public UserDto getUserByUserName(@PathVariable(value = "username") final String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping(value = "/users-by-fname/{firstName}")
    public List<UserDto> getUsersByFirstName(@PathVariable(value = "firstName") final String firstName) {
        return this.userService.getUsersByFirstname(firstName);
    }

    @PutMapping(value = "/users/{userId}")
    public void putUser(@RequestHeader(value = "Key") final String key,
        @PathVariable(value = "userId") final String userName, final String firstName, final String lastName) {

        this.validator.validateParams(key, userName, firstName, lastName);
        final UserDto employeeDto = UserDto.builder() // @formatter:off
            .username(userName)
            .firstName(firstName)
            .lastName(lastName)
            .build(); // @formatter:on
        this.userService.putEmployee(employeeDto);
    }

}
