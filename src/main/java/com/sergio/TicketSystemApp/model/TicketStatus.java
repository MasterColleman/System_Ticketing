package com.sergio.TicketSystemApp.model;

import java.util.ArrayList;

public class TicketStatus {

    private StateType actualState;//este atributo se usa para mostrar el estado actual del ticket

    public TicketStatus() {
        actualState = StateType.openByUser;
    }

    public void changeStateAuto() {//cambia el estado del ticket al siguiente estado a menos que este Concluido
        StateType state = this.actualState;
        switch (state) {
            case openByUser -> state = StateType.awaitingAssignmentAndResponse;
            case awaitingAssignmentAndResponse -> state = StateType.atReceptionDiagnosis;
            case atReceptionDiagnosis -> state = StateType.inProcessing;
            case inProcessing -> state = StateType.inTestingReview;
            case inTestingReview -> state = StateType.concluded;
        }
        this.actualState = state;
    }

    public StateType getActualState() {
        return actualState;
    }

    public void setActualState(StateType actualState) {
        this.actualState = actualState;
    }

    public void setFirstState() {
        this.actualState = StateType.openByUser;
    }

}
