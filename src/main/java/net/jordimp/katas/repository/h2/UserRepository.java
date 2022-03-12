package net.jordimp.katas.repository.h2;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jordimp.katas.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, UserRepositoryCustom {

    Optional<UserEntity> findByUsername(final String username);

}
