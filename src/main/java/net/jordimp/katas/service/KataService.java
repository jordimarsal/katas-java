package net.jordimp.katas.service;

import java.util.List;

import net.jordimp.katas.dto.KataDto;
import net.jordimp.katas.dto.UserDto;

public interface KataService {

    List<KataDto> getKatas();

    UserDto getKataByName(String name);

    List<KataDto> getKatasByLanguage(String language);

}
