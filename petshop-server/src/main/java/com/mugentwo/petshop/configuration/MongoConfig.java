package com.mugentwo.petshop.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mugentwo.petshop.PetShopApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@RequiredArgsConstructor
@EnableReactiveMongoRepositories(basePackageClasses = {PetShopApplication.class})
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    private final PetShopProperties petShopProperties;

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(petShopProperties.getMongo().getUri());
    }

    @Override
    protected String getDatabaseName() {
        return petShopProperties.getMongo().getDb();
    }

}
