package ec.com.sofka.queries.query;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.gateway.IEventStore;
import ec.com.sofka.generics.interfaces.IUseCaseGetElement;
import ec.com.sofka.generics.shared.QueryResponse;
import ec.com.sofka.queries.responses.MatchStateResponse;
import reactor.core.publisher.Mono;

public class QueryMatchState implements IUseCaseGetElement<String, MatchStateResponse> {
    private final IEventStore repository;

    public QueryMatchStateUseCase(IEventStore repository) {
        this.repository = repository;
    }

    @Override
    public Mono<QueryResponse<MatchStateResponse>> get(String matchId) {
        return repository.findAggregate(matchId)
                .collectList()
                .map(events -> MatchAggregate.from(matchId, events))
                .flatMap(matchAggregate -> {
                    MatchStateResponse response = new MatchStateResponse(
                            matchAggregate.getMatchState().getId().getValue(),
                            matchAggregate.getMatchState().getStatus(),
                            matchAggregate.getMatchState().getCurrentPlayer().getValue(),
                            matchAggregate.getMatchState().getWinner() != null
                                    ? matchAggregate.getMatchState().getWinner().getValue() : null
                    );
                    return Mono.just(QueryResponse.ofSingle(response));
                });
    }
}

 */
