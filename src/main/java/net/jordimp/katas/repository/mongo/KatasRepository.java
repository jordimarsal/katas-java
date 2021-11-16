package net.jordimp.katas.repository.mongo;

import org.springframework.data.repository.CrudRepository;

import net.jordimp.katas.entity.KataEntity;

public interface KatasRepository extends CrudRepository<KataEntity, String> {

}
