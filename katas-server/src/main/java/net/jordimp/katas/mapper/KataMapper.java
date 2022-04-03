package net.jordimp.katas.mapper;

import org.mapstruct.Mapper;

;import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.entity.KataEntity;

@Mapper
public interface KataMapper {

    KataDto toDto(KataEntity entity);
    KataEntity toEntity(KataDto dto);
}
