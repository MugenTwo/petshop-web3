package com.mugentwo.petshop;

import java.util.List;

public record Adoption(
        String name,
        String ownerAddress,
        String contractAddress,
        List<String> adopters
) {

}
