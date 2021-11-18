package net.jordimp.katas.repository.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jordimp.katas.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, UserRepositoryCustom {

    UserEntity findByUsername(final String username);

}
