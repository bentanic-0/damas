package ec.com.sofka.rules.impl;
/*
import ec.com.sofka.gateway.dto.BoardDTO;

import ec.com.sofka.rules.IValidateMatchState;
import ec.com.sofka.utils.enums.MatchStatusEnum;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ValidateMatchStateImpl implements IValidateMatchState {

    @Override
    public Mono<MatchStatusEnum> validateMatchState(BoardDTO board) {
        return Mono.fromCallable(() -> {
            long player1Pieces = board.getPieces().values().stream()
                    .filter(piece -> piece.getColor().equals("WHITE"))
                    .count();

            long player2Pieces = board.getPieces().values().stream()
                    .filter(piece -> piece.getColor().equals("BLACK"))
                    .count();

            if (player1Pieces == 0) {
                return MatchStatusEnum.FINISHED;
            }

            if (player2Pieces == 0) {
                return MatchStatusEnum.FINISHED;
            }

            return MatchStatusEnum.ACTIVE;
        });
    }
}

 */
