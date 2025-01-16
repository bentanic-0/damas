package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.MatchDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMatchRepository {
    Mono<MatchDTO> save(MatchDTO matchStateDTO);
    Mono<MatchDTO> findById(String matchStateId);
    Flux<MatchDTO> findAll();
}
