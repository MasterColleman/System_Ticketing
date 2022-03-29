package com.sergio.TicketSystemApp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TicketManager {

    private ArrayList<Ticket> ticketsList;
    private AssignedTechnician assignedTechnician;
    private ContactMethod contactMethod;
    private PriorityType priorityType;
    private TicketHashtags ticketHashtags;
    private int count;

    public TicketManager() {
        ticketsList = new ArrayList<>();
    }

    public ArrayList<Ticket> getTicketsList() {
        return this.ticketsList;
    }

    public void setListCustomers(ArrayList<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    //Agregar Ticket a Lista de Tickets
    public void addTicket(Ticket ticket){
        ticket.setTicketNumber(count++);
        ticket.setTicketCreationDate();
        ticket.setTimeByState();
        ticket.setTicketStatus();
        ticketsList.add(ticket);
    }

    //Buscar Ticket por Numero de Ticket
    public Ticket searchTicketByNumber(String ticketNumber){
    Ticket ticketX = null;
        for (int x = 0; x < ticketsList.size(); x++) {
            ticketX = ticketsList.get(x);
            if (ticketX.getTicketNumber().equalsIgnoreCase(ticketNumber)) {
                return ticketX;
            }
        }
        return ticketX;
    }

    //METODOS PARA DESPLEGABLES
    public AssignedTechnician chooseAgent(int election) {
    AssignedTechnician Agent;
        switch (election) {
            case 2 -> Agent = assignedTechnician.AgentTwo;
            case 3 -> Agent = assignedTechnician.AgentThree;
            case 4 -> Agent = assignedTechnician.AgentFour;
            case 5 -> Agent = assignedTechnician.AgentFive;
            default -> Agent = assignedTechnician.AgentOne;
        }
        return Agent;
    }

    public ContactMethod chooseContactMethod(int election) {
        ContactMethod contact = null;
        switch (election) {
            case 2 -> contact = contactMethod.whatsApp;
            case 3 -> contact = contactMethod.email;
            case 4 -> contact = contactMethod.phoneCall;
            case 5 -> contact = contactMethod.homeDelivery;
            case 6 -> contact = contactMethod.inPerson;
            case 7 -> contact = contactMethod.anySocialRed;
            default -> contact = contactMethod.ticketSystem;
        }
        return contact;
    }

    public PriorityType choosePriorityType(int election) {
        PriorityType priority;
        switch (election) {
            case 1 -> priority = priorityType.low;
            case 2 -> priority = priorityType.medium;
            case 3 -> priority = priorityType.high;
            default -> priority = priorityType.urgent;
        }
        return priority;
    }


    //Metodo Habilitar Lista de Etiquetas por Tipo de Servicio
    public ArrayList<String> getHashtagsList(TicketServiceType ticketServiceType){
        ticketHashtags.enableHashtagList(ticketServiceType);
        return ticketHashtags.getHashtagsListToTicket() ;
    }

    //Metodo Añadir las palabras clave al campo Etiquetas del Ticket >>>>>NO ME DI MAñAS DE HACERLO XDD<<<<

    /*public String addTicketHashtags(Ticket ticket, String hashtagsIn){
        ticket.getTicketHashtags().addWordsToHashtags(hashtagsIn);
        return hashtagsIn;
    }*/


    //Metodos para actualizar atributos del Ticket INDIVIDUALMENTE

    public void updateTicketStatus(Ticket ticket){
        ticket.getTicketStatus().changeStateAuto();
    }

    public void updateTicketServiceType(Ticket ticket, TicketServiceType serviceType){
        ticket.setTicketServiceType(serviceType);
    }

    public void updateTicketPriority(Ticket ticket, PriorityType priority){
        ticket.getTicketPriority().setPriority(priority);
    }

    public void updateTicketAssignedTechnician(Ticket ticket, AssignedTechnician agentTechnician){
        ticket.setAssignedTechnician(agentTechnician);
    }

    public void updateTicketHashtags(Ticket ticket, String hastags){
        ticket.getTicketHashtags().addWordsToHashtags(hastags);
    }

    public void updateTicketDeadline(Ticket ticket, TicketDeadline deadline){///MODIFICAR CLASE
        ticket.setTicketDeadline(deadline);
    }


    //Metodos para actualizar CASO y DATO DEL CLIENTE del ticket

    public void updateTicketCase(Ticket ticket, TicketServiceType ticketServiceType, TicketPriority ticketPriority,
                                 AssignedTechnician assignedTechnician, TicketHashtags ticketHashtags,
                                 ContactMethod contactMethodToUpdateClient, TicketDeadline ticketDeadline) {
        ticket.setTimeByState();
        ticket.setTicketServiceType(ticketServiceType);
        ticket.setTicketPriority(ticketPriority);
        ticket.setTicketHashtags(ticketHashtags);
        ticket.setTicketDeadline(ticketDeadline);//getticketpriority para actualizar deadline
        ticket.setAssignedTechnician(assignedTechnician);
        ticket.setContactMethodToUpdateClient(contactMethodToUpdateClient);
    }

    public void updateClientDataTicket(Ticket ticket, String clientName, String clientEmail, String clientCellPhoneNumber,
                                        ContactMethod contactMethodToUpdateClient) {
        ticket.setClientName(clientName);
        ticket.setClientEmail(clientEmail);
        ticket.setClientCellPhoneNumber(clientCellPhoneNumber);
        ticket.setContactMethodToUpdateClient(contactMethodToUpdateClient);
    }


    //Metodos para actualizar HISTORIAL del Ticket

    public void addDescriptionInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent, String detailSourceRequest){
        ticket.getTicketHistory().addDescription(boxSubtitle, boxContent,ticket.getClientName(), ticket.getSourceRequest(),
                detailSourceRequest);
    }

    public void addRespondeInTicketHistory(Ticket ticket, String boxContent, String detailSourceRequest){
        ticket.getTicketHistory().addResponse( ticket.getAssignedTechnician(),  boxContent, ticket.getClientName(),
                ticket.getSourceRequest(), detailSourceRequest);
    }

    public void addMessageInTicketHistory(Ticket ticket, String boxTitle, String boxSubtitle, String boxContent, String detailSourceRequest){
        ticket.getTicketHistory().addMessage( boxTitle, boxSubtitle, boxContent, ticket.getClientName(),
                ticket.getSourceRequest(), detailSourceRequest );
    }

    public void addUpdateInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent){
        ticket.getTicketHistory().addUpdate( ticket.getAssignedTechnician(), boxSubtitle, boxContent );
    }

    public void addStateUpdateInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent){
        ticket.getTicketHistory().addStateUpdate( ticket.getAssignedTechnician(), boxSubtitle, boxContent, ticket.getTicketStatus() );
    }

    public void addCalendarAppointmentInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent, LocalDateTime dateTime){
        ticket.getTicketHistory().addCalendarAppointment( ticket.getAssignedTechnician(), boxSubtitle, boxContent, ticket.getTicketStatus(), dateTime );
    }

    public void addConclusionInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent){
        ticket.getTicketHistory().addConclusion( ticket.getAssignedTechnician(), boxSubtitle, boxContent );
    }

    public void addTicketDeleteInTicketHistory(Ticket ticket, String boxSubtitle, String boxContent){
        ticket.getTicketHistory().addTicketDelete( ticket.getAssignedTechnician(), boxSubtitle, boxContent );
    }

}
