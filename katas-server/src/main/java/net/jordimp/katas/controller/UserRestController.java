package net.jordimp.katas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.jordimp.katas.controller.validation.Validator;
import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.service.UserService;

/**
 * UserRestController provides a REST API for the UserService.
 *
 * @author: Jordi Marsal.
 *
 */
@Tag(name = "UserRestController",
    description = "This is the main controller for getting User' Information")
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserRestController {

    /**
     * UserService instance.
     */
    private final UserService userService;
    /**
     * Validator instance.
     */
    private final Validator validator;

    @Value("${server.port}")
    private int serverPort;

    private static final String BR = "<br><br>";

    /**
     * Information endpoint.
     *
     * @return endpoints.
     */
    @GetMapping(value = "/")
    public String root() {
        // @formatter:off
        return "<html><h3>Endpoints:<br>----------------</h3><br>"
               + this.stem() + " this page" + BR
               + this.link("/users/") + BR
               + "/users/{username} -> " + this.link("/users/guest") + BR
               + "/users/{username} -> Also update with PUT" + BR
               + this.link("/users-by-fname/Jordi") + BR
               + this.link("/katas") + BR
               + "API: " + this.link("/swagger-ui.html") + BR
               + "API: " + this.link("/v3/api-docs/")
               + "</html>";
        // @formatter:on
    }

    private String stem() {
        return "http://localhost:" + this.serverPort;
    }

    private String link(final String suffix) {
        return "<a href=\"" + this.stem() + suffix + "\">" + suffix + "</a>";
    }

    /**
     * Get all users.
     *
     * @return list of UserDtos.
     */
    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

    /**
     * Get user by username.
     *
     * @param username username.
     * @return UserDto.
     */
    @GetMapping(value = "/users/{username}")
    public UserDto getUserByUserName(@PathVariable(value = "username") final String username) {
        return this.userService.getUserByUsername(username);
    }

    /**
     * Get users by first name.
     * @param firstName firstName
     * @return list of UserDtos.
     */
    @GetMapping(value = "/users-by-fname/{firstName}")
    public List<UserDto> getUsersByFirstName(@PathVariable(value = "firstName") final String firstName) {
        return this.userService.getUsersByFirstname(firstName);
    }

    /**
     * Update user by username
     *
     * @param key RequestHeader
     * @param userName username PathVariable
     * @param firstName firstName Form Url Encoded
     * @param lastName lastName Form Url Encoded
     *
     */
    @PutMapping(value = "/users/{username}")
    public void putUser(@RequestHeader(value = "Key") final String key,
        @PathVariable(value="username") final String userName, final String firstName, final String lastName) {

        this.validator.validateParams(key, userName, firstName, lastName);
        final UserDto employeeDto = UserDto.builder() // @formatter:off
            .username(userName)
            .firstName(firstName)
            .lastName(lastName)
            .build(); // @formatter:on
        this.userService.updateUser(employeeDto);
    }

    // TODO: Add create user
    // TODO: Add create / update form Vue.js??

}
