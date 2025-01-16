package ec.com.sofka.rules.impl;

import ec.com.sofka.gateway.dto.PieceDTO;

import ec.com.sofka.rules.IPromoteToKing;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PromoteToKingImpl implements IPromoteToKing {

    @Override
    public Mono<PieceDTO> promote(PieceDTO piece) {
        return Mono.fromCallable(() -> {
            if (piece.getColor().equals("WHITE") && piece.getPosition().endsWith("8")) {
                piece.setKing(true);
            }

            if (piece.getColor().equals("BLACK") && piece.getPosition().endsWith("1")) {
                piece.setKing(true);
            }

            return piece;
        });
    }
}
