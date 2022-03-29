package com.sergio.TicketSystemApp.controllers;

import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.home.JPanelHome;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Controller {
    private static Controller instance;
    private TicketManager ticketManager;


    private Controller() {
        ticketManager = TicketManager.getInstance();
        JPanelHome.getInstance();
        // add some tickets
        Ticket ticket1 = new Ticket("#0001", TicketServiceType.technicalService, new TicketStatus(),
                                    "Esto es un nombre de ticket", "Elizabeth", "eli@gmail.com", "3145422323",
                                    ContactMethod.email, new TicketPriority(), AssignedTechnician.AgentFive,
                                    new TicketHashtags(), ContactMethod.whatsApp, LocalDate.now(), null,
                                    StateType.openByUser.getStateType(), new TicketHistory());
        ticket1.getTicketHistory()
            .addDescription(ticket1.getTicketName(), "Esto es una descripcion del ticket", ticket1.getClientName(),
                            ticket1.getSourceRequest(), "detalles de " + "source requeas");
        ticket1.getTicketHistory()
            .addResponse(AssignedTechnician.AgentFive, "Esto es una respuesta del agente 5", "Elizabeth",
                         ContactMethod.email, "aqui no se que poner");

        ticketManager.addTicket(ticket1);
    }

    public static Controller getInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }

    public List<Ticket> getTickets() {
        return ticketManager.getTicketsList();
    }

    public void createTicket(Object ticket) {
        // TODO: implement
    }

    public List<Object> getResponsesFromTicket(String i) {
        // TODO: implement
        return null;
    }

    public List<Ticket> getTicketsByState(int state) {
        System.out.println(ticketManager.getTicketsByState(state));
        return ticketManager.getTicketsByState(state);
    }

    public List<Object> getResponsesFromTicket(String i) {
        // TODO: implement
        return null;
    }
}
