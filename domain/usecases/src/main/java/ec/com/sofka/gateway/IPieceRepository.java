package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.PieceDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPieceRepository {
    Mono<PieceDTO> save(PieceDTO pieceDTO);
    Mono<PieceDTO> findById(String pieceId);
    Flux<PieceDTO> findAll();
}
