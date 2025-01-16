package ec.com.sofka.rules;

import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.gateway.dto.MoveDTO;
import reactor.core.publisher.Mono;

public interface IValidateMove {
    /**
     * Validates if a move is valid based on the current board state.
     *
     * @param board The current board state.
     * @param move  The move to validate.
     * @return A Mono with the validated move.
     */
    Mono<MoveDTO> validateMove(BoardDTO board, MoveDTO move);
}
