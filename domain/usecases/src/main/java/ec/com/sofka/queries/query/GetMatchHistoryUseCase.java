package ec.com.sofka.queries.query;
/*
import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.usecases.gateway.IMatchRepository;
import ec.com.sofka.generics.interfaces.IUseCaseGet;
import ec.com.sofka.generics.shared.QueryResponse;
import ec.com.sofka.mapper.MatchMapper;
import ec.com.sofka.queries.responses.MatchResponse;
import reactor.core.publisher.Flux;

public class GetMatchHistoryQuery implements IUseCaseGet<MatchResponse> {
    private final IMatchRepository matchRepository;

    public GetMatchHistoryUseCase(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Flux<QueryResponse<MatchResponse>> get() {
        return getAllMatches()
                .map(MatchMapper::mapToResponseFromModel)
                .collectList()
                .flatMapMany(list -> Flux.just(QueryResponse.ofMultiple(list)));
    }

    public Flux<MatchAggregate> getAllMatches() {
        return matchRepository.findAll()
                .map(MatchMapper::mapToModelFromDTO);
    }
}

 */
