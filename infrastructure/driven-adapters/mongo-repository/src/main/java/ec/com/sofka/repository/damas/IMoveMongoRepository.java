package ec.com.sofka.repository.damas;

import ec.com.sofka.data.MoveEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IMoveMongoRepository extends ReactiveMongoRepository<MoveEntity, String> {

    Mono<MoveEntity> findById(String id);

    Flux<MoveEntity> findByMatchId(String matchId);

    Flux<MoveEntity> findByPlayerId(String playerId);

}
