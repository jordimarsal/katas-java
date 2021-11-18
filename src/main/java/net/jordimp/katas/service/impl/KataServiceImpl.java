package net.jordimp.katas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.entity.KataEntity;
import net.jordimp.katas.mapper.KataMapper;
import net.jordimp.katas.repository.mongo.KataRepository;
import net.jordimp.katas.service.KataService;

@RequiredArgsConstructor
@Service
public class KataServiceImpl implements KataService {

    private final KataRepository kataRepository;
    private final KataMapper kataMapstruct;

    @Override
    public List<KataDto> getAllKatas() {
        return this.kataEntityToDto((List<KataEntity>) this.kataRepository.findAll());
    }

    @Override
    public KataDto getKataById(final String id) {

        return this.kataMapstruct.toDto(this.kataRepository.findById(id).orElse(null));
    }

    @Override
    public KataDto getKataByName(final String name) {

        return this.kataMapstruct.toDto(this.kataRepository.findByName(name));
    }

    @Override
    public KataDto createKata(final KataDto kataDto) {

        return this.kataMapstruct.toDto(this.kataRepository.save(this.kataMapstruct.toEntity(kataDto)));
    }

    @Override
    public KataDto updateKata(final KataDto kataDto) {

        return this.kataMapstruct.toDto(this.kataRepository.save(this.kataMapstruct.toEntity(kataDto)));
    }

    @Override
    public void deleteKata(final String id) {

        this.kataRepository.deleteById(id);
    }

    @Override
    public List<KataDto> getKatasByLanguage(final String language) {
        return this.kataEntityToDto(this.kataRepository.findByLanguage(language));
    }

    private List<KataDto> kataEntityToDto(final List<KataEntity> kataEntities) {
        return kataEntities.stream() // @formatter:off
            .map(this.kataMapstruct::toDto)
            .collect(Collectors.toList()); // @formatter:on
    }

}
