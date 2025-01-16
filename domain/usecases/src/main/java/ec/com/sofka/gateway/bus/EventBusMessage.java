package ec.com.sofka.gateway.bus;

import ec.com.sofka.generics.domain.DomainEvent;

public interface EventBusMessage {
    void sendEvent(DomainEvent event);
}
