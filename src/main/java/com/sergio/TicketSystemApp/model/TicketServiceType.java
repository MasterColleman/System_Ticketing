package com.sergio.TicketSystemApp.model;

public enum TicketServiceType {

    technicalService("Servicio Tecnico"),
    technicalSupport("Soporte Tecnico"),
    assembly("Ensamblaje"),
    micro_Consulting("Micro-Consultoria")
    ;

    private final String ticketServiceType;

    TicketServiceType(String ticketServiceType) {
        this.ticketServiceType = ticketServiceType;
    }

    public String getTicketServiceType() {
        return ticketServiceType;
    }

    @Override
    public String toString() {
        return getTicketServiceType();
    }
}
