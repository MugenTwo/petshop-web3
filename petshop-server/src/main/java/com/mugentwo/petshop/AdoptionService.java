package com.mugentwo.petshop;

import com.mugentwo.petshop.contract.AdoptionContractService;
import com.mugentwo.petshop.contracts.AdoptionContract;
import com.mugentwo.petshop.pet.Pet;
import com.mugentwo.petshop.pet.PetMapper;
import com.mugentwo.petshop.pet.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.mugentwo.petshop.util.Web3jUtil.async;

@Service
@RequiredArgsConstructor
public class AdoptionService {

    private final PetService petService;
    private final AdoptionContractService adoptionContractService;
    private final PetMapper petMapper;

    public Mono<Adoption> create(Adoption adoption) {
        return adoptionContractService.deploy()
                .flatMap(account -> petService.save(petMapper.map(adoption, account.getContractAddress()))
                        .flatMap(pet -> map(account, pet)))
                .cache();
    }

    public Flux<Adoption> get(String ownerAddress) {
        return petService.getAll(ownerAddress)
                .flatMap(pet ->
                        adoptionContractService.load(pet.getContractAddress())
                                .flatMap(account -> map(account, pet))
                );
    }

    public Mono<String> adopt(String contractAddress, int petId) {
        return adoptionContractService.adopt(contractAddress, petId)
                .cache();
    }

    Mono<Adoption> map(AdoptionContract contract, Pet pet) {
        return async(contract.getAdopters()).map(contractData -> petMapper.mapWithContractData(pet, contractData));
    }

}
