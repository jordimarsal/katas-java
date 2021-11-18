package net.jordimp.katas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.entity.KataEntity;
import net.jordimp.katas.mapper.KataMapper;
import net.jordimp.katas.repository.mongo.KataRepository;
import net.jordimp.katas.service.KataService;

@Service
public class KataServiceImpl implements KataService {

    private final KataRepository kataRepository;

    public KataServiceImpl(final KataRepository kataRepository) {

        this.kataRepository = kataRepository;
    }

    @Override
    public List<KataDto> getAllKatas() {
        return KataMapper.kataEntityToDto((List<KataEntity>) this.kataRepository.findAll());
    }

    @Override
    public KataDto getKataById(final String id) {

        return KataMapper.toDto(this.kataRepository.findById(id).orElse(null));
    }

    @Override
    public KataDto getKataByName(final String name) {

        return KataMapper.toDto(this.kataRepository.findByName(name));
    }

    @Override
    public KataDto createKata(final KataDto kataDto) {

        return KataMapper.toDto(this.kataRepository.save(KataMapper.toEntity(kataDto)));
    }

    @Override
    public KataDto updateKata(final KataDto kataDto) {

        return KataMapper.toDto(this.kataRepository.save(KataMapper.toEntity(kataDto)));
    }

    @Override
    public void deleteKata(final String id) {

        this.kataRepository.deleteById(id);
    }

    @Override
    public List<KataDto> getKatasByLanguage(final String language) {
        return KataMapper.kataEntityToDto(this.kataRepository.findByLanguage(language));
    }

}
