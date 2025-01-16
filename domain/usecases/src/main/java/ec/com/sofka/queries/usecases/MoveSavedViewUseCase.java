package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.IMoveRepository;
import ec.com.sofka.gateway.dto.MoveDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class MoveSavedViewUseCase implements IUseCaseAccept<MoveDTO> {
    private final IMoveRepository moveRepository;

    public MoveSavedViewUseCase(IMoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    @Override
    public void accept(MoveDTO moveDTO) {
        moveRepository.save(moveDTO)
                .subscribe();
    }
}