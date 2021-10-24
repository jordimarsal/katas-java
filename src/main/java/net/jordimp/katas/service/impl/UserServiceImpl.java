package net.jordimp.katas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.entity.UserEntity;
import net.jordimp.katas.mapper.UserMapper;
import net.jordimp.katas.repository.UserRepository;
import net.jordimp.katas.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUsers() {

        final List<UserEntity> userEntities = (List<UserEntity>) this.userRepository.findAll();
        return UserMapper.userEntityToDto(userEntities);

    }

    @Override
    public UserDto getUserByUsername(final String username) {

        UserEntity userEntity = userRepository.findByUsername(username);
        return UserMapper.toDto(userEntity);
    }

}
