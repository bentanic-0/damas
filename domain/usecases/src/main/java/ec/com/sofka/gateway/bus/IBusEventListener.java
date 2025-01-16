package ec.com.sofka.gateway.bus;

import ec.com.sofka.generics.domain.DomainEvent;

public interface IBusEventListener {
    void receiveUserCreated(DomainEvent event);
    //void receiveUserUpdated(DomainEvent event);
   /* void receiveMatchCreated(DomainEvent event);
    void receiveMatchUpdated(DomainEvent event);
    void receivePieceMoved(DomainEvent event);
    void receiveMatchEnded(DomainEvent event);
    void receivePlayerJoined(DomainEvent event);
    void receivePlayerLeft(DomainEvent event);*/
}