package ec.com.sofka;

import ec.com.sofka.gateway.IBoardRepository;
import ec.com.sofka.repository.damas.IBoardMongoRepository;
import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.mapper.BoardEntityMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BoardMongoAdapter implements IBoardRepository {
    private final IBoardMongoRepository boardRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public BoardMongoAdapter(IBoardMongoRepository boardRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.boardRepository = boardRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<BoardDTO> save(BoardDTO boardDTO) {
        return boardRepository.save(BoardEntityMapper.mapToEntity(boardDTO))
                .map(BoardEntityMapper::mapToDTO);
    }

    @Override
    public Mono<BoardDTO> findById(String boardId) {
        return boardRepository.findById(boardId)
                .map(BoardEntityMapper::mapToDTO);
    }

    @Override
    public Flux<BoardDTO> findAll() {
        return boardRepository.findAll()
                .map(BoardEntityMapper::mapToDTO);
    }
}