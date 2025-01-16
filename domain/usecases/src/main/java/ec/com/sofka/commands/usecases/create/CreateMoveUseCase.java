package ec.com.sofka.commands.usecases.create;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.commands.MoveCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.mapper.MoveMapper;
import ec.com.sofka.queries.responses.MoveResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreateMoveUseCase {
    private final IEventStore repository;
    private final EventBusMessage eventBusMessage;

    public CreateMoveUseCase(IEventStore repository, EventBusMessage eventBusMessage) {
        this.repository = repository;
        this.eventBusMessage = eventBusMessage;
    }

    public Mono<MoveResponse> execute(MoveCommand moveCommand) {
        return repository.findAggregate(moveCommand.getAggregateId())
                .collectList()
                .map(events -> MatchAggregate.from(moveCommand.getAggregateId(), events))
                .flatMap(matchAggregate -> {
                    matchAggregate.createMove(
                            moveCommand.getAggregateId(),
                            moveCommand.getPieceId(),
                            moveCommand.getStartPosition(),
                            moveCommand.getEndPosition(),
                            moveCommand.isCapture()
                    );

                    return Flux.fromIterable(matchAggregate.getUncommittedEvents())
                            .flatMap(repository::save)
                            .doOnNext(eventBusMessage::sendEvent)
                            .then(Mono.fromCallable(() -> {
                                matchAggregate.markEventsAsCommitted();
                                return MoveMapper.mapToResponseFromModel(
                                        matchAggregate.getMove(moveCommand.getAggregateId())
                                                .orElseThrow(() -> new RuntimeException("Move not found"))
                                );
                            }));
                });
    }
}
*/
