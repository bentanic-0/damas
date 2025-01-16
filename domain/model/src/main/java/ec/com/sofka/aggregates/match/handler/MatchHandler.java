package ec.com.sofka.aggregates.match.handler;

import ec.com.sofka.aggregates.match.MatchAggregate;
import ec.com.sofka.aggregates.match.entities.board.Board;
import ec.com.sofka.aggregates.match.entities.match.Match;
import ec.com.sofka.aggregates.match.entities.move.Move;
import ec.com.sofka.aggregates.match.entities.move.values.MoveId;
import ec.com.sofka.aggregates.match.entities.piece.Piece;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Color;
import ec.com.sofka.aggregates.match.entities.player.Player;
import ec.com.sofka.aggregates.match.events.*;
import ec.com.sofka.generics.domain.DomainActionsContainer;
import ec.com.sofka.utils.enums.MatchStatusEnum;
import ec.com.sofka.aggregates.match.entities.player.values.PlayerId;
import ec.com.sofka.aggregates.match.entities.piece.values.PieceId;
import ec.com.sofka.aggregates.match.entities.piece.values.objects.Position;

public class MatchHandler extends DomainActionsContainer {
    public MatchHandler(MatchAggregate matchAggregate) {

        addDomainActions((MatchCreated event) -> {
            Match Match = new Match(
                    event.getMatchId(),
                    event.getMatchState().getStatus(),
                    PlayerId.of(event.()),
                    event.getWinnerId()
            ));
            matchAggregate.setBoard(event.getBoard());
            matchAggregate.setPlayer1(event.getPlayer1());
            matchAggregate.setPlayer2(event.getPlayer2());
        });
/*
        addDomainActions((MatchUpdated event) -> {
            matchAggregate.setMatchState(new Match(
                    event.getMatchId(),
                    event.getMatchState().getStatus(),
                    PlayerId.of(event.getCurrentPlayerId()),
                    event.getWinnerId()
            ));
        });

        addDomainActions((BoardCreated event) -> {
            matchAggregate.setBoard(new Board(
                    event.getBoardId(),
                    event.getSize() // Asumiendo que el Board tiene un tamaño
            ));
        });

        addDomainActions((BoardUpdated event) -> {
            matchAggregate.getBoard().update(event.getNewSize()); // Asumiendo que el Board tiene un método update
        });*/

        addDomainActions((PieceCreated event) -> {
            matchAggregate.getPiece().addPiece(new Piece(
                    PieceId.of(event.getPieceId()),
                    Color.of(event.getColor()),
                    Position.of(event.getPosition()),
                    event.isKing()
            ));
        });
/*
        addDomainActions((PieceUpdated event) -> {
            matchAggregate.getBoard().updatePiece(
                    PieceId.of(event.getPieceId()),
                    event.getColor(),
                    Position.of(event.getPosition()),
                    event.isKing()
            );
        });*/

        addDomainActions((MoveCreated event) -> {
            Move move = new Move(
                    MoveId.of(event.getMoveId()),
                    PlayerId.of(event.getPlayerId()),
                    PieceId.of(event.getPieceId()),
                    Position.of(event.getStartPosition()),
                    Position.of(event.getEndPosition()),
                    event.isCapture()
            );
            matchAggregate.().put(event.getMoveId(), move);
        });
/*
        addDomainActions((MoveUpdated event) -> {
            Move move = matchAggregate.getMove(event.getMoveId())
                    .orElseThrow(() -> new IllegalArgumentException("Move not found"));
            move.update(
                    PieceId.of(event.getPieceId()),
                    Position.of(event.getStartPosition()),
                    Position.of(event.getEndPosition()),
                    event.isCapture()
            );
        });

        addDomainActions((PlayerCreated event) -> {
            Player player = new Player(
                    PlayerId.of(event.getPlayerId()),
                    event.getName(),
                    event.getColor() // Asumiendo que el Player tiene un color
            );
            if (matchAggregate.getPlayer1() == null) {
                matchAggregate.setPlayer1(player);
            } else {
                matchAggregate.setPlayer2(player);
            }
        });*/

    }
}