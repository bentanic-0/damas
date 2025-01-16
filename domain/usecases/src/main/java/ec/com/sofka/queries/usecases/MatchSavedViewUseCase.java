package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.dto.MatchDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;


public class MatchSavedViewUseCase implements IUseCaseAccept<MatchDTO> {
    private final IMatchRepository matchRepository;

    public MatchSavedViewUseCase(IMatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void accept(MatchDTO matchDTO) {
        matchRepository.save(matchDTO)
                .subscribe();
    }
}
