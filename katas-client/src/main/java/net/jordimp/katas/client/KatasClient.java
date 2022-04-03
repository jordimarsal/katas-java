package net.jordimp.katas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import net.jordimp.katas.dto.KataDto;

@FeignClient(name = "katas-client", url = "${client.katas.url}", path = "/katas")
public interface KatasClient {

    KataDto getKataById(@RequestParam String id);
}
