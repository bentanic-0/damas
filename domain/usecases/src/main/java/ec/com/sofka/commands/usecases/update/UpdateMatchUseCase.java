package ec.com.sofka.commands.usecases.update;

import ec.com.sofka.commands.MatchCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.IMatchRepository;
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.generics.domain.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UpdateMatchUseCase {

    private final IEventStore matchRepository;

    @Autowired
    public UpdateMatchUseCase(IMatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Mono<MatchAggregate> execute(MatchCommand command) {
        return matchRepository.findById(command.getAggregateId())
                .flatMap(matchAggregate -> {
                    // Actualiza el estado del partido
                    matchAggregate.updateMatchState(command.getMatchState().getStatus(), command.getWinnerId());
                    // Guardar el MatchAggregate actualizado en el repositorio
                    return matchRepository.save(matchAggregate);
                });
    }
}