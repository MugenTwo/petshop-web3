package com.mugentwo.petshop.pet;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Pet {

    @Id
    String name;
    String ownerAddress;
    String contractAddress;

}
