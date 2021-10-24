package net.jordimp.katas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jordimp.katas.entity.UserEntity;
import net.jordimp.katas.repository.h2.UserRepositoryCustom;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, UserRepositoryCustom {

    UserEntity findByUsername(final String username);

}
