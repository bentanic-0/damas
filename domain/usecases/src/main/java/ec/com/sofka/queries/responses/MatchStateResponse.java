package ec.com.sofka.queries.responses;

import ec.com.sofka.utils.enums.MatchStatusEnum;

import java.io.Serializable;

public class MatchStateResponse implements Serializable {
    private MatchStatusEnum status;
    private String currentPlayerId;
    private String winnerPlayerId;

    public MatchStateResponse(MatchStatusEnum status, String currentPlayerId, String winnerPlayerId) {

        this.status = status;
        this.currentPlayerId = currentPlayerId;
        this.winnerPlayerId = winnerPlayerId;
    }


    public MatchStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MatchStatusEnum status) {
        this.status = status;
    }

    public String getCurrentPlayerId() {
        return currentPlayerId;
    }

    public void setCurrentPlayerId(String currentPlayerId) {
        this.currentPlayerId = currentPlayerId;
    }

    public String getWinnerPlayerId() {
        return winnerPlayerId;
    }

    public void setWinnerPlayerId(String winnerPlayerId) {
        this.winnerPlayerId = winnerPlayerId;
    }
}
