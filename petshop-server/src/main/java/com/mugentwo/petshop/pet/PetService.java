package com.mugentwo.petshop.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Mono<Pet> save(Pet pet) {
        return petRepository.save(pet);
    }

    public Flux<Pet> getAll(String ownerAddress) {
        return petRepository.findAllByOwnerAddress(ownerAddress);
    }

}
