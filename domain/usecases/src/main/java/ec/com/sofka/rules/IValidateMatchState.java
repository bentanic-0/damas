package ec.com.sofka.rules;

import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.utils.enums.MatchStatusEnum;
import reactor.core.publisher.Mono;

public interface IValidateMatchState {
    /**
     * Validates the match state based on the board.
     *
     * @param board The current board state.
     * @return A Mono with the match status.
     */
    Mono<MatchStatusEnum> validateMatchState(BoardDTO board);
}
