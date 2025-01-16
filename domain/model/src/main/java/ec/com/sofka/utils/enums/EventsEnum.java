package ec.com.sofka.utils.enums;

import java.util.Arrays;

public enum EventsEnum {

    // Eventos relacionados con usuarios
    USER_CREATED(
            "USER_CREATED",
            "user.created.exchange",
            "user.created.queue",
            "user.created.routingKey"
    ),
    USER_UPDATED(
            "USER_UPDATED",
            "user.updated.exchange",
            "user.updated.queue",
            "user.updated.routingKey"
    ),

    // Eventos relacionados con partidas
    MATCH_STARTED(
            "MATCH_STARTED",
            "game.started.exchange",
            "game.started.queue",
            "game.started.routingKey"
    ),
    MATCH_ENDED(
            "MATCH_ENDED",
            "game.ended.exchange",
            "game.ended.queue",
            "game.ended.routingKey"
    ),
    MATCH_STATE_UPDATED(
            "MATCH_STATE_UPDATED",
            "game.state.updated.exchange",
            "game.state.updated.queue",
            "game.state.updated.routingKey"
    ),

    // Eventos relacionados con el tablero
    BOARD_GENERATED(
            "BOARD_GENERATED",
            "board.generated.exchange",
            "board.generated.queue",
            "board.generated.routingKey"
    ),
    PIECE_MOVED(
            "PIECE_MOVED",
            "piece.moved.exchange",
            "piece.moved.queue",
            "piece.moved.routingKey"
    ),
    PIECE_STATE_UPDATED(
            "PIECE_STATE_UPDATED",
            "piece.state.updated.exchange",
            "piece.state.updated.queue",
            "piece.state.updated.routingKey"
    );

    private final String eventType;
    private final String exchange;
    private final String queue;
    private final String routingKey;

    EventsEnum(String eventType, String exchange, String queue, String routingKey) {
        this.eventType = eventType;
        this.exchange = exchange;
        this.queue = queue;
        this.routingKey = routingKey;
    }

    public static EventsEnum findByEventType(String eventType) {
        return Arrays.stream(EventsEnum.values())
                .filter(event -> event.getEventType().equals(eventType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Event type not found: " + eventType));
    }

    public String getEventType() {
        return eventType;
    }

    public String getExchange() {
        return exchange;
    }

    public String getQueue() {
        return queue;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
