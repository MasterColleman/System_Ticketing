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
        String description = "Hola! Quería pedirles ayuda a ustedes, ya que desde hace unos días he intentado cargar mi " +
                "celular y no he podido conseguir que la barra de estado de energía de la batería llegue al 100%, aun " +
                "dejándolo toda la noche conectado, compre hasta un cargador nuevo (oficial) y siguió igual. Además de " +
                "que no carga por completo, se descarga cuando llega al 15% y la verdad uso mucho mi celular por contactos" +
                " laborales y chat del trabajo. Mi celular es muy buen celular cuando lo compre me informe bien " +
                "(me costó mucho y que tiene buenas especificaciones), aunque es cierto que llevo varios años con él, " +
                "unos 4 al menos, y solo hasta hace poco ha empezado a fallar.";
        String response = "Hola Elizabeth! Lo primero que haremos es abrir un ticket en nuestro sistema y subir la " +
                "información al mismo para que si gustas le hagas seguimiento por ahí, sin embargo, si quieres podemos " +
                "enviarte las actualizaciones a tu caso por otro medio.";
        List<String> listaTiempoPorEstados = new ArrayList<>(Arrays.asList("0 h", "0 h", "0 h", "0 h", "0 h"));
        Ticket ticket1 = new Ticket("#2902022SERTEC1", TicketServiceType.technicalService, new TicketStatus(),
                                    "Problemas con mi celular", "Elizabeth", "eli1993@gmail.com",
                                    "3145422323", ContactMethod.email, new TicketPriority(),
                                    AssignedTechnician.AgentFive, new TicketHashtags(), ContactMethod.whatsApp,
                                    LocalDateTime.now(), new TicketDeadline(), listaTiempoPorEstados, new TicketHistory());
        ticket1.getTicketHistory()
            .addDescription(ticket1.getTicketName(), description, ticket1.getClientName(),
                            ticket1.getSourceRequest(), "enviado a" + "hex.st.tech@gmail.com");
        ticket1.getTicketHistory()
            .addResponse(AssignedTechnician.AgentFive, response, "Elizabeth",
                         ContactMethod.email, "eli1993@gmail.com");

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


    public void updateTime(Ticket ticket, StateType state) {
        ticketManager.updateTimeByState(ticket, state);
        ticketManager.updateTicketDeadline(ticket,state);
    }

    public void updateState(Ticket ticket) {
        ticketManager.updateTicketStatus(ticket);
    }

    public void updateCalendarAppointment(Ticket ticket) {
    }

    public void updateServiceType(Ticket ticket, TicketServiceType type) {
        ticketManager.updateTicketServiceType(ticket, type);
    }

    public void updateAgent(Ticket ticket, AssignedTechnician agent) {
        ticketManager.updateTicketAssignedTechnician(ticket, agent);
    }

    public void updatePriority(Ticket ticket, PriorityType priority) {
        ticketManager.updateTicketPriority(ticket, priority);
    }

}
