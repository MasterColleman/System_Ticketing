package com.sergio.TicketSystemApp.model;

public enum ContactMethod {

    ticketSystem("Este Sistema de Tickets"),
    whatsApp("WhatsApp"),
    email("Correo Electronico"),
    phoneCall("Llamada Telefonica"),
    homeDelivery("A Domicilio"),
    inPerson("Presencial"),
    anySocialRed("Otra red social")
    ;
    private final String contactMethod;

    ContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getContactMethod() {
        return contactMethod;
    }

}
