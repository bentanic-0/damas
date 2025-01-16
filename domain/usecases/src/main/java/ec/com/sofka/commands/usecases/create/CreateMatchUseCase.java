package ec.com.sofka.commands.usecases.create;

import ec.com.sofka.commands.MatchCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.mapper.MatchMapper;
import ec.com.sofka.gateway.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateMatchUseCase {
    private final IEventStore eventStore;
    private final EventBusMessage eventBusMessage;

    @Autowired
    public CreateMatchUseCase(IEventStore eventStore, EventBusMessage eventBusMessage) {
        this.eventStore = eventStore;
        this.eventBusMessage = eventBusMessage;
    }

    public Mono<MatchDTO> execute(MatchCommand command) {
        MatchAggregate matchAggregate = new MatchAggregate();

        // Asegúrate de que el estado del partido se pase como cuarto argumento
        matchAggregate.createMatch(command.getPlayer1(), command.getPlayer2(), command.getBoard(), command.getMatchState());

        return Flux.fromIterable(matchAggregate.getUncommittedEvents())
                .flatMap(eventStore::save)
                .doOnNext(eventBusMessage::sendEvent)
                .then(Mono.fromCallable(() -> {
                    matchAggregate.markEventsAsCommitted();
                    return MatchMapper.mapToDTOFromModel(matchAggregate); // Cambié 'savedMatch' a 'matchAggregate'
                }));
    }
}