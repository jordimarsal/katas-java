package net.jordimp.katas.repository.h2;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.jordimp.katas.entity.UserEntity;

@Repository
public interface UserRepositoryCustom {

    List<UserEntity> findByFirstName(String firstName);

}
