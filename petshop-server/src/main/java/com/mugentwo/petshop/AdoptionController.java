package com.mugentwo.petshop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/adoption", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    @CrossOrigin(origins = "*")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Adoption> create(@RequestBody Adoption adoption) {
        return adoptionService.create(adoption);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public Flux<Adoption> get(@RequestParam String ownerAddress) {
        return adoptionService.get(ownerAddress);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adopt", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> adopt(@RequestBody Adopt adopt) {
        return adoptionService.adopt(adopt.contractAddress(), adopt.petId());
    }

}
