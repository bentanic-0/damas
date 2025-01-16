package ec.com.sofka.queries.usecases;


import ec.com.sofka.gateway.IBoardRepository;
import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.generics.interfaces.IUseCaseAccept;

public class BoardSavedViewUseCase implements IUseCaseAccept<BoardDTO> {
    private final IBoardRepository boardRepository;

    public BoardSavedViewUseCase(IBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void accept(BoardDTO boardDTO) {
        boardRepository.save(boardDTO)
                .subscribe();
    }
}