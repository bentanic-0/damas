package ec.com.sofka.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "ec.com.sofka.repository.damas",
        reactiveMongoTemplateRef = "damasMongoTemplate")
public class DamasMongoConfig {
    @Value("${spring.data.mongodb.damas-uri}")
    private String damasMongoUri;

    @Bean(name = "damasDatabaseFactory")
    public ReactiveMongoDatabaseFactory damasDatabaseFactory() {
        MongoClient mongoClient = MongoClients.create(damasMongoUri);
        return new SimpleReactiveMongoDatabaseFactory(mongoClient, "damas");
    }

    @Primary
    @Bean(name = "damasMongoTemplate")
    public ReactiveMongoTemplate damasMongoTemplate(@Qualifier("damasDatabaseFactory") ReactiveMongoDatabaseFactory damasDatabaseFactory) {
        return new ReactiveMongoTemplate(damasDatabaseFactory);
    }
}