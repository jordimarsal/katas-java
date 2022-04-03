package net.jordimp.katas.repository.h2.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jordimp.katas.entity.UserEntity;
import net.jordimp.katas.repository.h2.UserRepositoryCustom;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserEntity> findByFirstName(final String firstName) {

        final Query query = this.entityManager.createNativeQuery(
            "SELECT us.* FROM users as us " + "WHERE first_name = ?", UserEntity.class);
        query.setParameter(1, firstName);

        final Optional<List<UserEntity>> ret = Optional.ofNullable((List<UserEntity>) query.getResultList());

        return ret.orElse(new ArrayList<>());
    }

}
