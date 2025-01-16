package ec.com.sofka.repository.damas;

import ec.com.sofka.data.PlayerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPlayerMongoRepository extends ReactiveMongoRepository<PlayerEntity, String> {

    Mono<PlayerEntity> findById(String id);

    Flux<PlayerEntity> findByMatchId(String matchId);

}
