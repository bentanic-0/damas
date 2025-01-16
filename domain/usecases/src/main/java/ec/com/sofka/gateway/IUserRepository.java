package ec.com.sofka.gateway;

import ec.com.sofka.gateway.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserRepository {
    Mono<UserDTO> save(UserDTO userDTO);
    Mono<UserDTO> findByEmail(String email);
    Mono<UserDTO> findById(String userId);
    Flux<UserDTO> findAll();
}
