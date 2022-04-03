package net.jordimp.katas.service;

import java.util.List;

import net.jordimp.katas.dto.KataDto;

public interface KataService {

    List<KataDto> getAllKatas();

    KataDto getKataById(final String id);

    KataDto createKata(final KataDto kataDto);

    KataDto updateKata(final KataDto kataDto);

    void deleteKata(final String id);

    KataDto getKataByName(String name);

    List<KataDto> getKatasByLanguage(String language);

}
