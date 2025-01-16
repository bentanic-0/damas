package ec.com.sofka.gateway.bus;

import ec.com.sofka.model.ErrorMessage;

public interface ErrorBusMessage {
    void sendMsg(ErrorMessage message);
}