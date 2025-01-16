package ec.com.sofka.aggregates.match.events;

import ec.com.sofka.generics.domain.DomainEvent;

public class MatchUpdated extends DomainEvent {
    private final String matchId;
    private final String status;

    public MatchUpdated(String matchId, String status) {
        super("match.updated");
        this.matchId = matchId;
        this.status = status;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getStatus() {
        return status;
    }
}
