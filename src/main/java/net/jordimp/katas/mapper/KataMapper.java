package net.jordimp.katas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.entity.KataEntity;

public interface KataMapper {

    static List<KataDto> kataEntityToDto(final List<KataEntity> kataEntities) {

        return kataEntities.stream() // @formatter:off
            .map(KataMapper::toDto)
            .collect(Collectors.toList()); // @formatter:on
    }

    static KataDto toDto(final KataEntity entity) {
        return KataDto.builder() // @formatter:off
            .language(entity.getLanguage())
            .author(entity.getAuthor())
            .category(entity.getCategory())
            .name(entity.getName())
            .description(entity.getDescription())
            .url(entity.getUrl())
            .level(entity.getLevel())
            .date(entity.getDate())
            .time(entity.getTime())
            .id(entity.getId())
            .votes(entity.getVotes())
            .views(entity.getViews())
            .stars(entity.getStars())
            .build(); // @formatter:on
    }

    static KataEntity toEntity(KataDto dto) {
        return KataEntity.builder() // @formatter:off
            .language(dto.getLanguage())
            .author(dto.getAuthor())
            .category(dto.getCategory())
            .name(dto.getName())
            .description(dto.getDescription())
            .url(dto.getUrl())
            .level(dto.getLevel())
            .date(dto.getDate())
            .time(dto.getTime())
            .id(dto.getId())
            .votes(dto.getVotes())
            .views(dto.getViews())
            .stars(dto.getStars())
            .build(); // @formatter:on
    }

}
