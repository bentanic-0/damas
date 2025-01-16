package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.PlayerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPlayerRepository {
    Mono<PlayerDTO> save(PlayerDTO playerDTO);
    Mono<PlayerDTO> findById(String playerId);
    Flux<PlayerDTO> findAll();
}
