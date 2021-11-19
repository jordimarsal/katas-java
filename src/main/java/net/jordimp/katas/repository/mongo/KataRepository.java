package net.jordimp.katas.repository.mongo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.jordimp.katas.entity.KataEntity;

@Repository
public interface KataRepository extends CrudRepository<KataEntity, String> {

    List<KataEntity> findByLanguage(final String language);

    KataEntity findByName(final String name);

}
