package ec.com.sofka.repository.damas;

import ec.com.sofka.data.ErrorLogEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IErrorLogMongoRepository extends ReactiveMongoRepository<ErrorLogEntity, String> {

}