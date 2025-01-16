package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.IPlayerRepository;
import ec.com.sofka.gateway.dto.PlayerDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class PlayerSavedViewUseCase implements IUseCaseAccept<PlayerDTO> {
    private final IPlayerRepository playerRepository;

    public PlayerSavedViewUseCase(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void accept(PlayerDTO playerDTO) {
        playerRepository.save(playerDTO)
                .subscribe();
    }
}
