package net.jordimp.katas.service;

import java.util.List;

import net.jordimp.katas.dto.UserDto;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserByUsername(String username);

    List<UserDto> getUsersByFirstname(String firstName);

}
