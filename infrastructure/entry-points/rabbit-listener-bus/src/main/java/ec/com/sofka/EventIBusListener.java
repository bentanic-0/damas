package ec.com.sofka;

import ec.com.sofka.aggregates.auth.events.UserCreated;
import ec.com.sofka.gateway.bus.IBusEventListener;
import ec.com.sofka.generics.domain.DomainEvent;
import ec.com.sofka.mapper.*;
import ec.com.sofka.queries.usecases.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventIBusListener implements IBusEventListener {
    private final UserSavedViewUseCase userSavedViewUseCase;
    private final MatchSavedViewUseCase matchSavedViewUseCase;
    private final PieceSavedViewUseCase pieceSavedViewUseCase;
    private final MoveSavedViewUseCase moveSavedViewUseCase;
    private final MatchStateSavedViewUseCase matchStateSavedViewUseCase;

    public EventIBusListener(
            UserSavedViewUseCase userSavedViewUseCase,
            MatchSavedViewUseCase matchSavedViewUseCase,
            PieceSavedViewUseCase pieceSavedViewUseCase,
            MoveSavedViewUseCase moveSavedViewUseCase,
            MatchStateSavedViewUseCase matchStateSavedViewUseCase) {
        this.userSavedViewUseCase = userSavedViewUseCase;
        this.matchSavedViewUseCase = matchSavedViewUseCase;
        this.pieceSavedViewUseCase = pieceSavedViewUseCase;
        this.moveSavedViewUseCase = moveSavedViewUseCase;
        this.matchStateSavedViewUseCase = matchStateSavedViewUseCase;
    }

    @Override
    @RabbitListener(queues = "${user.created.queue}")
    public void receiveUserCreated(DomainEvent event) {
        UserCreated userCreated = (UserCreated) event;
        userSavedViewUseCase.accept(UserMapper.mapToDTOFromCreatedEvent(userCreated));
    }
/*
    @Override
    @RabbitListener(queues = "${user.updated.queue}")
    public void receiveUserUpdated(DomainEvent event) {
        UserUpdated userUpdated = (UserUpdated) event;
        userSavedViewUseCase.accept(UserMapper.mapToDTOFromUpdatedEvent(userUpdated));
    }

    @Override
    @RabbitListener(queues = "${match.created.queue}")
    public void receiveMatchCreated(DomainEvent event) {
        MatchCreated matchCreated = (MatchCreated) event;
        matchSavedViewUseCase.accept(MatchMapper.mapToDTOFromCreatedEvent(matchCreated));
    }

    @Override
    @RabbitListener(queues = "${match.updated.queue}")
    public void receiveMatchUpdated(DomainEvent event) {
        MatchUpdated matchUpdated = (MatchUpdated) event;
        matchSavedViewUseCase.accept(MatchMapper.mapToDTOFromUpdatedEvent(matchUpdated));
    }

    @Override
    @RabbitListener(queues = "${piece.moved.queue}")
    public void receivePieceMoved(DomainEvent event) {
        PieceMoved pieceMoved = (PieceMoved) event;
        pieceSavedViewUseCase.accept(PieceMapper.mapToDTOFromMovedEvent(pieceMoved));
    }

    @Override
    @RabbitListener(queues = "${match.ended.queue}")
    public void receiveMatchEnded(DomainEvent event) {
        MatchEnded matchEnded = (MatchEnded) event;
        matchSavedViewUseCase.accept(MatchMapper.mapToDTOFromEndedEvent(matchEnded));
    }

    @Override
    @RabbitListener(queues = "${player.joined.queue}")
    public void receivePlayerJoined(DomainEvent event) {
        PlayerJoined playerJoined = (PlayerJoined) event;
        // Implementar la lógica para manejar el evento de un jugador que se une
    }

    @Override
    @RabbitListener(queues = "${player.left.queue}")
    public void receivePlayerLeft(DomainEvent event) {
        PlayerLeft playerLeft = (PlayerLeft) event;
        // Implementar la lógica para manejar el evento de un jugador que se va
    }*/
}