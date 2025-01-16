package ec.com.sofka.gateway.bus;

import ec.com.sofka.model.ErrorMessage;

public interface BusErrorListener {

    void receiveLogError(ErrorMessage message);

}