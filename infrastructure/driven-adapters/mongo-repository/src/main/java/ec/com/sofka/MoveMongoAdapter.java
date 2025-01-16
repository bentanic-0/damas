package ec.com.sofka;

import ec.com.sofka.gateway.IMoveRepository;
import ec.com.sofka.repository.damas.IMoveMongoRepository;
import ec.com.sofka.gateway.dto.MoveDTO;
import ec.com.sofka.mapper.MoveEntityMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MoveMongoAdapter implements IMoveRepository {
    private final IMoveMongoRepository moveRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public MoveMongoAdapter(IMoveMongoRepository moveRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.moveRepository = moveRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<MoveDTO> save(MoveDTO moveDTO) {
        return moveRepository.save(MoveEntityMapper.mapToEntity(moveDTO))
                .map(MoveEntityMapper::mapToDTO);
    }

    @Override
    public Mono<MoveDTO> findById(String moveId) {
        return moveRepository.findById(moveId)
                .map(MoveEntityMapper::mapToDTO);
    }

    @Override
    public Flux<MoveDTO> findByMatchId(String matchId) {
        return moveRepository.findByMatchId(matchId)
                .map(MoveEntityMapper::mapToDTO);
    }
}