package ec.com.sofka.repository.damas;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


public interface IMatchStateMongoRepository extends ReactiveMongoRepository<MatchStateEntity, String> {

    Mono<MatchStateEntity> findById(String id);

    Mono<MatchStateEntity> findByMatchId(String matchId);

}
