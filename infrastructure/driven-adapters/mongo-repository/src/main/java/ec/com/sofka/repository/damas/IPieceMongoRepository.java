package ec.com.sofka.repository.damas;

import ec.com.sofka.data.PieceEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IPieceMongoRepository extends ReactiveMongoRepository<PieceEntity, String> {

    Mono<PieceEntity> findById(String id);

    Flux<PieceEntity> findByMatchId(String matchId);

    Flux<PieceEntity> findByPlayerId(String playerId);


}
