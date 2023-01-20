package com.mugentwo.petshop.pet;

import com.mugentwo.petshop.Adoption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface PetMapper {

    @Mapping(target = "adopters", source = "value")
    Adoption mapWithContractData(Pet pet, List<String> value);

    @Mapping(target = "contractAddress", source = "contractAddress")
    Pet map(Adoption adoption, String contractAddress);

}
