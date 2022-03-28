package com.sergio.TicketSystemApp.model;

import java.util.ArrayList;

public class TicketStatus {

    private StateType actualState;//este atributo se usa para mostrar el estado actual del ticket
    private StateType stateType;//enumerador de los tipos de estado

    public void changeStateAuto() {//cambia el estado del ticket al siguiente estado a menos que este Concluido
        StateType state = this.actualState;
        switch (state) {
            case openByUser:
                state = stateType.awaitingAssignmentAndResponse;
            case awaitingAssignmentAndResponse:
                state = stateType.atReceptionDiagnosis;
            case atReceptionDiagnosis:
                state = stateType.inProcessing;
            case inProcessing:
                state = stateType.inTestingReview;
            case inTestingReview:
                state = stateType.concluded;
        }
    }

    public StateType getActualState() {
        return actualState;
    }

    public void setActualState(StateType actualState) {
        this.actualState = actualState;
    }

    public void setFirstState(){
        this.actualState = stateType.openByUser;
    }

}
