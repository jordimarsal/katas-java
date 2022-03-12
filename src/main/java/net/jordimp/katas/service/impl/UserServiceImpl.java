package net.jordimp.katas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.jordimp.katas.controller.validation.exception.UserNotFoundException;
import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.entity.UserEntity;
import net.jordimp.katas.mapper.UserMapper;
import net.jordimp.katas.repository.h2.UserRepository;
import net.jordimp.katas.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        final List<UserEntity> userEntities = (List<UserEntity>) this.userRepository.findAll();
        return UserMapper.userEntityToDto(userEntities);
    }

    @Override
    public UserDto getUserByUsername(final String username) {
        final Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);
        return UserMapper.toDto(userEntity.orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    @Override
    public List<UserDto> getUsersByFirstname(final String firstName) {
        final List<UserEntity> userEntities = this.userRepository.findByFirstName(firstName);
        return UserMapper.userEntityToDto(userEntities);
    }

    @Override
    public void updateUser(final UserDto employeeDto) {
        final UserEntity userEntityOld = this.userRepository.findByUsername(employeeDto.getUsername())
            .orElseThrow(() -> new UserNotFoundException("User not found"));
        this.userRepository.save(UserMapper.toEntity(employeeDto, userEntityOld.getPassword()));
    }

}
