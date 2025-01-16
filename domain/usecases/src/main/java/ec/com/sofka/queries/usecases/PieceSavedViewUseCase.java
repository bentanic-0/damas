package ec.com.sofka.queries.usecases;

import ec.com.sofka.gateway.IPieceRepository;
import ec.com.sofka.gateway.dto.PieceDTO;

import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class PieceSavedViewUseCase implements IUseCaseAccept<PieceDTO> {
    private final IPieceRepository pieceRepository;

    public PieceSavedViewUseCase(IPieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }

    @Override
    public void accept(PieceDTO pieceDTO) {
        pieceRepository.save(pieceDTO)
                .subscribe();
    }
}