package net.jordimp.katas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import net.jordimp.katas.dto.UserDto;
import net.jordimp.katas.entity.UserEntity;

public interface UserMapper {

    static List<UserDto> userEntityToDto(final List<UserEntity> userEntities) {

        // @formatter:off
        return userEntities.stream()
            .map(UserMapper::toDto)
            .collect(Collectors.toList());
        // @formatter:on
    }

    static UserDto toDto(final UserEntity entity) {

        // @formatter:off
        return UserDto.builder()
            .username(entity.getUsername())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName())
            .build();
        // @formatter:on
    }

}
