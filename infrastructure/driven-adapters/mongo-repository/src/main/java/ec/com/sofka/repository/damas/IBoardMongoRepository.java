package ec.com.sofka.repository.damas;

import ec.com.sofka.data.BoardEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface IBoardMongoRepository extends ReactiveMongoRepository<BoardEntity, String> {

    Mono<BoardEntity> findById(String id);

    Mono<BoardEntity> findByMatchId(String matchId);

}
