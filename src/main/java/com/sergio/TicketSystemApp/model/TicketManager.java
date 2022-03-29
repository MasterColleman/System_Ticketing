package com.sergio.TicketSystemApp.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketManager {
    private static TicketManager instance;

    private ArrayList<Ticket> ticketsList;
    private AssignedTechnician assignedTechnician;
    private ContactMethod contactMethod;
    private PriorityType priorityType;
    private TicketHashtags ticketHashtags;
    private int count;

    public TicketManager() {
        ticketsList = new ArrayList<>();
    }

    public static TicketManager getInstance() {
        if (instance == null) {
            instance = new TicketManager();
        }
        return instance;
    }

    public ArrayList<Ticket> getTicketsList() {
        return this.ticketsList;
    }

    public void setListCustomers(ArrayList<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public List<Ticket> getTicketsByState(int state) {
        return switch (state) {
            case 0 -> getTicketByState(StateType.openByUser);
            case 1 -> getTicketByState(StateType.awaitingAssignmentAndResponse);
            case 2 -> getTicketByState(StateType.atReceptionDiagnosis);
            case 3 -> getTicketByState(StateType.inProcessing);
            case 4 -> getTicketByState(StateType.inTestingReview);
            case 5 -> getTicketByState(StateType.concluded);
            default -> List.of();
        };
    }

    private List<Ticket> getTicketByState(StateType state) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : ticketsList)
            if (ticket.getTicketStatus().getActualState() == state) tickets.add(ticket);
        return tickets;
    }
    //Agregar Ticket a Lista de Tickets
    public Ticket addTicket(Ticket ticket){
        ticket.setTicketNumber(++count);
        ticket.setTicketCreationDate();
        ticket.setTicketStatus();
        ticket.setTimeByState(Arrays.asList("0 h", "0 h", "0 h","0 h","0 h"));
        ticketsList.add(ticket);
        return ticket;
    }

    //Buscar Ticket por Numero de Ticket
    public Ticket searchTicketByNumber(String ticketNumber){
        for (Ticket ticket : ticketsList) {
            if (ticket.getTicketNumber().equalsIgnoreCase(ticketNumber)) {
                return ticket;
            }
        }
        return null;
    }

    //METODOS PARA DESPLEGABLES
    public AssignedTechnician chooseAgent(int election) {
    AssignedTechnician Agent;
        switch (election) {
            case 2 -> Agent = AssignedTechnician.AgentTwo;
            case 3 -> Agent = AssignedTechnician.AgentThree;
            case 4 -> Agent = AssignedTechnician.AgentFour;
            case 5 -> Agent = AssignedTechnician.AgentFive;
            default -> Agent = AssignedTechnician.AgentOne;
        }
        return Agent;
    }

    public ContactMethod chooseContactMethod(int election) {
        ContactMethod contact;
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

    public String addTicketHashtags(Ticket ticket, String hashtagsIn){
        ticket.getTicketHashtags().addWordsToHashtags(hashtagsIn);
        return hashtagsIn;
    }


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

    public void updateTimeByState(){

    }


    //Metodos para actualizar CASO y DATO DEL CLIENTE del ticket

    public void updateTicketCase(Ticket ticket, TicketServiceType ticketServiceType, TicketPriority ticketPriority,
                                 AssignedTechnician assignedTechnician, TicketHashtags ticketHashtags,
                                 ContactMethod contactMethodToUpdateClient, TicketDeadline ticketDeadline) {
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
