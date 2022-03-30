package com.sergio.TicketSystemApp.controllers;

import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.home.JPanelHome;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Controller {
    private static Controller instance;
    private TicketManager ticketManager;


    private Controller() {
        ticketManager = TicketManager.getInstance();
        JPanelHome.getInstance();
        // add some tickets
        List<String> listaTiempoPorEstados = new ArrayList<>(Arrays.asList("0 h", "0 h", "0 h", "0 h", "0 h"));
        Ticket ticket1 = new Ticket("#0001", TicketServiceType.technicalService, new TicketStatus(),
                                    "Esto es un nombre de ticket", "Elizabeth", "eli@gmail.com",
                                    "3145422323", ContactMethod.email, new TicketPriority(), AssignedTechnician.AgentFive,
                                    new TicketHashtags(), ContactMethod.whatsApp, LocalDateTime.now(), new TicketDeadline(),
                                    listaTiempoPorEstados, new TicketHistory());
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

    public Ticket createTicket(Ticket ticket, List<String> description) {
        Ticket newTicket = ticketManager.addTicket(ticket);
        ticketManager.addDescriptionInTicketHistory(newTicket, description.get(0), description.get(1),
                                                    description.get(2));
        return newTicket;
    }


    public List<Ticket> getTicketsByState(int state) {
        System.out.println(ticketManager.getTicketsByState(state));
        return ticketManager.getTicketsByState(state);
    }


    public Ticket getTicket(String id) {
        return ticketManager.searchTicketByNumber(id);
    }

    public void updateTicketCase(String id, TicketServiceType ticketServiceType, TicketPriority ticketPriority,
                                 AssignedTechnician assignedTechnician, TicketHashtags ticketHashtags,
                                 ContactMethod contactMethodToUpdateClient, TicketDeadline ticketDeadline) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.updateTicketCase(ticket, ticketServiceType, ticketPriority, assignedTechnician, ticketHashtags,
                                       contactMethodToUpdateClient, ticketDeadline);
    }

    public void addResponseInTicketHistory(String id, String boxContent, String detailSourceRequest) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addRespondeInTicketHistory(ticket, boxContent, detailSourceRequest);
    }

    public void addMessageInTicketHistory(String id, String boxTitle, String boxSubtitle, String boxContent,
                                          String detailSourceRequest) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addMessageInTicketHistory(ticket, boxTitle, boxSubtitle, boxContent, detailSourceRequest);
    }

    public void addUpdateInTicketHistory(String id, String boxSubtitle, String boxContent) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addUpdateInTicketHistory(ticket, boxSubtitle, boxContent);
    }

    public void addStateUpdateInTicketHistory(String id, String boxSubtitle, String boxContent) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addStateUpdateInTicketHistory(ticket, boxSubtitle, boxContent);
    }

    public void addCalendarAppointmentInTicketHistory(String id, String boxSubtitle, String boxContent,
                                                      LocalDateTime dateTime) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addCalendarAppointmentInTicketHistory(ticket, boxSubtitle, boxContent, dateTime);
    }

    public void addConclusionInTicketHistory(String id, String boxSubtitle, String boxContent) {
        Ticket ticket = ticketManager.searchTicketByNumber(id);
        ticketManager.addConclusionInTicketHistory(ticket, boxSubtitle, boxContent);
    }


}
