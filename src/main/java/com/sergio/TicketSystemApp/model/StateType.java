package com.sergio.TicketSystemApp.model;

public enum StateType {

    openByUser("Abierto por Usuario"),
    awaitingAssignmentAndResponse("En Espera de Asignación y Respuesta"),
    atReceptionDiagnosis("En Recepción / Diagnostico"),
    inProcessing("En Procesamiento"),
    inTestingReview("En Testeo / Revisión"),
    concluded("Concluido")
    ;

    private final String stateType;

    StateType(String stateType) {
        this.stateType = stateType;
    }

    public String getStateType() {
        return stateType;
    }

}
