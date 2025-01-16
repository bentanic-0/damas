package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.MoveDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMoveRepository {
    Mono<MoveDTO> save(MoveDTO moveDTO);
    Flux<MoveDTO> findByMatchId(String matchId);
    Mono<MoveDTO> findById(String moveId);
}
