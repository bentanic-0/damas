package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.BoardDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IBoardRepository {
    Mono<BoardDTO> save(BoardDTO boardDTO);
    Mono<BoardDTO> findById(String boardId);
    Flux<BoardDTO> findAll();
}
