package ec.com.sofka;

import ec.com.sofka.gateway.IPlayerRepository;
import ec.com.sofka.repository.damas.IPlayerMongoRepository;
import ec.com.sofka.gateway.dto.PlayerDTO;
import ec.com.sofka.mapper.PlayerEntityMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PlayerMongoAdapter implements IPlayerRepository {
    private final IPlayerMongoRepository playerRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public PlayerMongoAdapter(IPlayerMongoRepository playerRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.playerRepository = playerRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<PlayerDTO> save(PlayerDTO playerDTO) {
        return playerRepository.save(PlayerEntityMapper.mapToEntity(playerDTO))
                .map(PlayerEntityMapper::mapToDTO);
    }

    @Override
    public Mono<PlayerDTO> findById(String playerId) {
        return playerRepository.findById(playerId)
                .map(PlayerEntityMapper::mapToDTO);
    }

    @Override
    public Flux<PlayerDTO> findAll() {
        return playerRepository.findAll()
                .map(PlayerEntityMapper::mapToDTO);
    }
}