package ec.com.sofka;

import ec.com.sofka.gateway.IUserRepository;
import ec.com.sofka.repository.damas.IUserMongoRepository;
import ec.com.sofka.gateway.dto.UserDTO;
import ec.com.sofka.mapper.UserEntityMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserMongoAdapter implements IUserRepository {
    private final IUserMongoRepository userRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public UserMongoAdapter(IUserMongoRepository userRepository, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.userRepository = userRepository;
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<UserDTO> save(UserDTO userDTO) {
        return userRepository.save(UserEntityMapper.mapToEntity(userDTO))
                .map(UserEntityMapper::mapToDTO);
    }

    @Override
    public Mono<UserDTO> findById(String userId) {
        return userRepository.findById(userId)
                .map(UserEntityMapper::mapToDTO);
    }

    @Override
    public Flux<UserDTO> findAll() {
        return userRepository.findAll()
                .map(UserEntityMapper::mapToDTO);
    }

    @Override
    public Mono<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserEntityMapper::mapToDTO);
    }
}