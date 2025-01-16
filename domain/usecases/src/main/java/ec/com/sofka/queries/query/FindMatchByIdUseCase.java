package ec.com.sofka.queries.query;

import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.bus.ErrorBusMessage;
import ec.com.sofka.gateway.IMatchRepository;
import ec.com.sofka.generics.interfaces.IUseCaseGetElement;
import ec.com.sofka.generics.shared.PropertyQuery;
import ec.com.sofka.generics.shared.QueryResponse;
import ec.com.sofka.mapper.MatchMapper;
import ec.com.sofka.model.ErrorMessage;
import ec.com.sofka.queries.responses.MatchResponse;
import reactor.core.publisher.Mono;

public class FindMatchByIdQuery implements IUseCaseGetElement<PropertyQuery, MatchResponse> {
    private final IMatchRepository matchRepository;
    private final ErrorBusMessage errorBusMessage;

    public FindMatchByIdQuery(IMatchRepository matchRepository, ErrorBusMessage errorBusMessage) {
        this.matchRepository = matchRepository;
        this.errorBusMessage = errorBusMessage;
    }

    @Override
    public Mono<QueryResponse<MatchResponse>> get(PropertyQuery request) {
        return getByMatchId(request.getProperty())
                .map(MatchMapper::mapToResponseFromModel)
                .flatMap(matchResponse -> Mono.just(QueryResponse.ofSingle(matchResponse)));
    }

    public Mono<MatchAggregate> getByMatchId(String matchId) {
        return matchRepository.findById(matchId)
                .switchIfEmpty(Mono.defer(() -> {
                    errorBusMessage.sendMsg(new ErrorMessage("Match not found", "Get Match by ID"));
                    return Mono.error(new RecordNotFoundException("Match not found."));
                }))
                .map(MatchMapper::mapToModelFromDTO);
    }
}

 */