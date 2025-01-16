package ec.com.sofka.rules.impl;
/*
import ec.com.sofka.gateway.dto.BoardDTO;
import ec.com.sofka.gateway.dto.MoveDTO;
import ec.com.sofka.gateway.dto.PieceDTO;
import ec.com.sofka.rules.IValidateMove;
import ec.com.sofka.utils.enums.MoveTypeEnum;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class ValidateMoveImpl implements IValidateMove {

    @Override
    public Mono<MoveDTO> validateMove(BoardDTO board, MoveDTO move) {
        return Mono.fromCallable(() -> {
            Optional<PieceDTO> piece = Optional.ofNullable(board.getPieces().get(move.getPieceId()));

            if (piece.isEmpty() || !piece.get().getPosition().equals(move.getStartPosition())) {
                throw new IllegalArgumentException("Invalid piece or start position.");
            }

            if (!isValidMove(piece.get(), move)) {
                throw new IllegalArgumentException("Invalid move for the piece.");
            }

            return move;
        });
    }

    private boolean isValidMove(PieceDTO piece, MoveDTO move) {
        // Implement game-specific rules for valid moves
        // For example: diagonal movement, capturing an opponent, etc.
        return move.getMoveType() == MoveTypeEnum.REGULAR ||
                move.getMoveType() == MoveTypeEnum.CAPTURE;
    }
}

 */