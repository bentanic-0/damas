package ec.com.sofka.commands.usecases.create;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.commands.PieceCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.generics.interfaces.IUseCaseExecute;
import ec.com.sofka.mapper.PieceMapper;
import ec.com.sofka.queries.responses.PieceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreatePieceUseCase implements IUseCaseExecute<PieceCommand, PieceResponse> {
    private final IEventStore repository;
    private final EventBusMessage eventBusMessage;

    public CreatePieceUseCase(IEventStore repository, EventBusMessage eventBusMessage) {
        this.repository = repository;
        this.eventBusMessage = eventBusMessage;
    }

    @Override
    public Mono<PieceResponse> execute(PieceCommand pieceCommand) {
        return repository.findAggregate(pieceCommand.getAggregateId())
                .collectList()
                .map(events -> MatchAggregate.from(pieceCommand.getAggregateId(), events))
                .flatMap(matchAggregate -> {
                    matchAggregate.createPiece(
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