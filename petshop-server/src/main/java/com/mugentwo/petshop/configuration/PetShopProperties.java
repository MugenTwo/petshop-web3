package com.mugentwo.petshop.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigInteger;

@ConfigurationProperties("x")
@Data
public class PetShopProperties {

    private BigInteger gasPrice = BigInteger.ZERO;
    private BigInteger gasLimit = BigInteger.valueOf(6721975);
    private long chainId;

    private AccountKeysProperties accountKeys;
    private Web3jProperties web3j;
    private PetShopMongoProperties mongo;

    @Data
    public static class AccountKeysProperties {

        private String system;

    }

    @Data
    public static class Web3jProperties {

        private String clientAddress;

    }

    @Data
    public static class PetShopMongoProperties {

        private String uri;
        private String db;

    }

}
