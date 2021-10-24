package net.jordimp.katas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jordimp.katas.repository.h2.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<Long, UserEntity> {

    UserEntity findByUsername(String isbn);

    List<UserEntity> findByFirstName(String title);

}
