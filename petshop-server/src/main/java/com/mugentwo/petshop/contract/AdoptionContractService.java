package com.mugentwo.petshop.contract;

import com.mugentwo.petshop.contracts.AdoptionContract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

import static com.mugentwo.petshop.util.Web3jUtil.async;

@Service
@RequiredArgsConstructor
public class AdoptionContractService {

    private final Web3j web3j;
    private final ContractGasProvider contractGasProvider;

    private final TransactionManager systemTransactionManager;

    public Mono<AdoptionContract> deploy() {
        return async(AdoptionContract.deploy(web3j, systemTransactionManager, contractGasProvider));
    }

    public Mono<AdoptionContract> load(String contractAddress) {
        return Mono.fromCallable(() -> AdoptionContract.load(contractAddress, web3j, systemTransactionManager, contractGasProvider));
    }

    public Mono<String> adopt(String contractAddress, int petId) {
        return async(AdoptionContract.load(contractAddress, web3j, systemTransactionManager, contractGasProvider)
                .adopt(BigInteger.valueOf(petId)))
                .map(TransactionReceipt::getStatus);
    }


}
