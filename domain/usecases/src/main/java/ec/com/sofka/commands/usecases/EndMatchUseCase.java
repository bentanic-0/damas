package ec.com.sofka.commands.usecases;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.commands.MatchCommand;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.gateway.bus.EventBusMessage;
import ec.com.sofka.mapper.*;
import ec.com.sofka.queries.responses.MatchResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class EndMatchUseCase {
    private final IEventStore repository;
    private final EventBusMessage eventBusMessage;

    public EndMatchUseCase(IEventStore repository, EventBusMessage eventBusMessage) {
        this.repository = repository;
        this.eventBusMessage = eventBusMessage;
    }

    public Mono<MatchResponse> execute(MatchCommand gameCommand) {
        return repository.findAggregate(gameCommand.getAggregateId())
                .collectList()
                .map(events -> MatchAggregate.from(gameCommand.getAggregateId(), events))
                .flatMap(matchAggregate -> {
                    matchAggregate.endMatch(
                            gameCommand.getWinnerId(),
                            gameCommand.isDraw()
                    );

                    return Flux.fromIterable(matchAggregate.getUncommittedEvents())
                            .flatMap(repository::save)
                            .doOnNext(eventBusMessage::sendEvent)
                            .then(Mono.fromCallable(() -> {
                                matchAggregate.markEventsAsCommitted();
                                return new MatchResponse(
                                        PlayerMapper.mapToResponseFromModel(matchAggregate.getPlayer1(), gameCommand.getPlayer1UserResponse()),
                                        PlayerMapper.mapToResponseFromModel(matchAggregate.getPlayer2(), gameCommand.getPlayer2UserResponse()),
                                        BoardMapper.mapToResponseFromModel(matchAggregate.getBoard()),
                                        MatchStateMapper.mapToResponseFromModel(matchAggregate.getMatchState()),
                                        matchAggregate.getMoves().values().stream()
                                                .map(move -> MoveMapper.mapToResponseFromModel(move))
                                                .toList(),
                                        matchAggregate.getBoard().getPieces().entrySet().stream()
                                                .collect(Collectors.toMap(
                                                        entry -> entry.getKey().getValue(),
                                                        entry -> PieceMapper.mapToResponseFromModel(entry.getValue())
                                                ))
                                );
                            }));
                });
    }
}

 */
