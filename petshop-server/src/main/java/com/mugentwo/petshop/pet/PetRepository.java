package com.mugentwo.petshop.pet;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PetRepository extends ReactiveMongoRepository<Pet, UUID> {

    Flux<Pet> findAllByOwnerAddress(String ownerAddress);

}
