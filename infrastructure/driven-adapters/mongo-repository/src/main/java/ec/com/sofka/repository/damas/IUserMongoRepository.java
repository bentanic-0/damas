package ec.com.sofka.repository.damas;

import ec.com.sofka.data.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IUserMongoRepository extends ReactiveMongoRepository<UserEntity, String> {

    Mono<UserEntity> findByEmail(String email);

    Mono<UserEntity> findById(String id);

}
