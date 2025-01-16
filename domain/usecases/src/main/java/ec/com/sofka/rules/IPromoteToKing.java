package ec.com.sofka.rules;

import ec.com.sofka.gateway.dto.PieceDTO;
import reactor.core.publisher.Mono;

public interface IPromoteToKing {
    /**
     * Promotes a piece to a king if it reaches the appropriate position.
     *
     * @param piece The piece to check for promotion.
     * @return A Mono with the updated piece.
     */
    Mono<PieceDTO> promote(PieceDTO piece);
}
