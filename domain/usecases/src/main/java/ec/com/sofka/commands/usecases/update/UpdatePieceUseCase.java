package ec.com.sofka.commands.usecases.update;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.commands.PieceCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.mapper.PieceMapper;
import ec.com.sofka.queries.responses.PieceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UpdatePieceUseCase {
    private final IEventStore repository;
    private final EventBusMessage eventBusMessage;

    public UpdatePieceUseCase(IEventStore repository, EventBusMessage eventBusMessage) {
        this.repository = repository;
        this.eventBusMessage = eventBusMessage;
    }

    public Mono<PieceResponse> execute(PieceCommand pieceCommand) {
        return repository.findAggregate(pieceCommand.getAggregateId())
                .collectList()
                .map(events -> MatchAggregate.from(pieceCommand.getAggregateId(), events))
                .flatMap(matchAggregate -> {
                    matchAggregate.updatePiece(
                            pieceCommand.getAggregateId(),
                            pieceCommand.getColor(),
                            pieceCommand.getPosition(),
                            pieceCommand.isKing()
                    );

                    return Flux.fromIterable(matchAggregate.getUncommittedEvents())
                            .flatMap(repository::save)
                            .doOnNext(eventBusMessage::sendEvent)
                            .then(Mono.fromCallable(() -> {
                                matchAggregate.markEventsAsCommitted();
                                return PieceMapper.mapToResponseFromModel(
                                        matchAggregate.getPiece(pieceCommand.getAggregateId())
                                                .orElseThrow(() -> new RuntimeException("Piece not found"))
                                );
                            }));
                });
    }
}

 */
