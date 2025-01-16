package ec.com.sofka.queries.query;

/*
import ec.com.sofka.gateway.IMatchRepository;
import ec.com.sofka.mapper.MatchMapper;
import ec.com.sofka.generics.shared.QueryResponse;
import ec.com.sofka.queries.responses.MatchResponse;
import reactor.core.publisher.Flux;

public class FindAllMatchesQuery {
    private final IMatchRepository matchRepository;

    public FindAllMatchesQuery(IMatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Flux<QueryResponse<MatchResponse>> execute() {
        return matchRepository.findAll()
                .map(MatchMapper::mapToResponseFromDTO)
                .collectList()
                .flatMapMany(list -> {
                    QueryResponse<MatchResponse> queryResponse = QueryResponse.ofMultiple(list);
                    return Flux.just(queryResponse);
                });
    }
}

 */