package ec.com.sofka;

import ec.com.sofka.repository.damas.IErrorLogMongoRepository;
import ec.com.sofka.gateway.IErrorLogRepository;
import ec.com.sofka.mapper.ErrorLogEntityMapper;
import ec.com.sofka.model.ErrorMessage;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ErrorLogMongoAdapter implements IErrorLogRepository {
    private final IErrorLogMongoRepository repository;
    private final ReactiveMongoTemplate accountReactiveMongoTemplate;

    public ErrorLogMongoAdapter(IErrorLogMongoRepository repository, ReactiveMongoTemplate accountReactiveMongoTemplate) {
        this.repository = repository;
        this.accountReactiveMongoTemplate = accountReactiveMongoTemplate;
    }

    @Override
    public Mono<ErrorMessage> save(ErrorMessage errorMessage) {
        return repository.save(ErrorLogEntityMapper.mapToEntity(errorMessage))
                .map(ErrorLogEntityMapper::mapToModel);
    }
}