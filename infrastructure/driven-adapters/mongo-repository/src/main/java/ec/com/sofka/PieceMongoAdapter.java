package ec.com.sofka;

import ec.com.sofka.gateway.IPieceRepository;
import ec.com.sofka.repository.damas.IPieceMongoRepository;
import ec.com.sofka.gateway.dto.PieceDTO;
import ec.com.sofka.mapper.PieceEntityMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PieceMongoAdapter implements IPieceRepository {
    private final IPieceMongoRepository pieceRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public PieceMongoAdapter(IPieceMongoRepository pieceRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.pieceRepository = pieceRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<PieceDTO> save(PieceDTO pieceDTO) {
        return pieceRepository.save(PieceEntityMapper.mapToEntity(pieceDTO))
                .map(PieceEntityMapper::mapToDTO);
    }

    @Override
    public Mono<PieceDTO> findById(String pieceId) {
        return pieceRepository.findById(pieceId)
                .map(PieceEntityMapper::mapToDTO);
    }

    @Override
    public Flux<PieceDTO> findAll() {
        return pieceRepository.findAll()
                .map(PieceEntityMapper::mapToDTO);
    }
}