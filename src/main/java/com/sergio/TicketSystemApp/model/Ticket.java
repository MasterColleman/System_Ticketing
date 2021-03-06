package com.sergio.TicketSystemApp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private String ticketNumber;//Numero de ticket autogenerado
    private TicketServiceType ticketServiceType;//Enumerado del tipo de Servicio referente al ticket
    private TicketStatus ticketStatus;//Clase de Estado del Ticket
    private String ticketName;
    private String clientName, clientEmail, clientCellPhoneNumber;
    private ContactMethod sourceRequest;//Fuente primaria de donde vino la solicitud para abrir ticket
    private TicketPriority ticketPriority;//Clase Prioridad para establecer tiempos para plazo de entrega
    private AssignedTechnician assignedTechnician;//Enumerado de Agente o Tecnico, asignado al caso o ticket
    private TicketHashtags ticketHashtags;//Clase
    private ContactMethod contactMethodToUpdateClient;//Enumerado
    private LocalDateTime ticketCreationDate;
    private TicketDeadline ticketDeadline;//Clase Plazo de Entrega
    private List<String> timeByState;
    private TicketHistory ticketHistory;//Clase que contiene todas las cajas con los cambios del ticket incluida la descripcion
    private int totalTime;

    public Ticket(String ticketNumber, TicketServiceType ticketServiceType, TicketStatus ticketStatus,
                  String ticketName, String clientName, String clientEmail, String clientCellPhoneNumber,
                  ContactMethod sourceRequest, TicketPriority ticketPriority, AssignedTechnician assignedTechnician,
                  TicketHashtags ticketHashtags, ContactMethod contactMethodToUpdateClient,
                  LocalDateTime ticketCreationDate, TicketDeadline ticketDeadline, List<String> timeByState,
                  TicketHistory ticketHistory) {
        this.ticketNumber = ticketNumber;
        this.ticketServiceType = ticketServiceType;
        this.ticketStatus = ticketStatus;
        this.ticketName = ticketName;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientCellPhoneNumber = clientCellPhoneNumber;
        this.sourceRequest = sourceRequest;
        this.ticketPriority = ticketPriority;
        this.assignedTechnician = assignedTechnician;
        this.ticketHashtags = ticketHashtags;
        this.contactMethodToUpdateClient = contactMethodToUpdateClient;
        this.ticketCreationDate = ticketCreationDate;
        this.ticketDeadline = ticketDeadline;
        this.timeByState = timeByState;
        this.ticketHistory = ticketHistory;
        this.timeByState = new ArrayList<>(5);
    }

    //Metodo SOLO SE USA UNA VEZ para setear la lista de tiempos por estado
    public void setTimeByState(List<String> firstTimeByState){
        this.timeByState = firstTimeByState;
    }

    //Metodo para setear Tiempos por Estado para Actualizacion del Ticket.
    //>>>>>>>>>>>>>>>>>>>>>>EJECUTAR CADA VEZ QUE SE CAMBIE DE ESTADO EN EL TICKET<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public void setTimeByState(TicketStatus ticketStatus, TicketDeadline ticketDeadline,
    LocalDateTime ticketCreationDate, TicketPriority ticketPriority, StateType stateTypeIn){
        int timeStop = (ticketPriority.getTimeForPriority()
                    - ticketDeadline.getDeadlineTimeAtAnyTime(ticketCreationDate, ticketPriority, stateTypeIn));
        switch (ticketStatus.getActualState()) {
            case openByUser-> timeByState.set(0,timeStop + " h");
            case inProcessing-> timeByState.set(1,timeStop + " h");
            case awaitingAssignmentAndResponse-> timeByState.set(2,timeStop + " h");
            case atReceptionDiagnosis-> timeByState.set(3,timeStop + " h");
            case inTestingReview-> timeByState.set(4,timeStop + " h");
        }
        totalTime += timeStop;
    }

    public int getTotalTime(){
        return totalTime;
    }

    public void setTicketNumber(int count) {
        LocalDate today = LocalDate.now();
        String formattedToday = today.format(DateTimeFormatter.ofPattern("ddMMyy"));
        this.ticketNumber = "#" + formattedToday + switch (ticketServiceType)  {
            case technicalService -> "SERTEC";
            case assembly -> "ENSMBJ";
            case micro_Consulting -> "MICRCS";
            case technicalSupport -> "SPRTEC";
        } + count;
    }

    public void setTicketServiceType(TicketServiceType ticketServiceType) {
        this.ticketServiceType = ticketServiceType;
    }

    public void setTicketStatus() {
        this.ticketStatus.setFirstState();
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientCellPhoneNumber(String clientCellPhoneNumber) {
        this.clientCellPhoneNumber = clientCellPhoneNumber;
    }

    public void setSourceRequest(ContactMethod sourceRequest) {
        this.sourceRequest = sourceRequest;
    }

    public void setTicketPriority(TicketPriority ticketPriority) {
        this.ticketPriority = ticketPriority;
    }

    public void setAssignedTechnician(AssignedTechnician assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    public void setTicketHashtags(TicketHashtags ticketHashtags) {
        this.ticketHashtags = ticketHashtags;
    }

    public void setContactMethodToUpdateClient(ContactMethod contactMethodToUpdateClient) {
        this.contactMethodToUpdateClient = contactMethodToUpdateClient;
    }

    public void setTicketCreationDate() {
        this.ticketCreationDate = LocalDateTime.now();
    }

    public void setTicketDeadline(TicketPriority ticketPriority) {
        this.ticketDeadline.setDeadLineTime(ticketPriority);
    }

    public void setTicketHistory(TicketHistory ticketHistory) {
        this.ticketHistory = ticketHistory;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public TicketServiceType getTicketServiceType() {
        return ticketServiceType;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public String getTicketName() {
        return ticketName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientCellPhoneNumber() {
        return clientCellPhoneNumber;
    }

    public ContactMethod getSourceRequest() {
        return sourceRequest;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public AssignedTechnician getAssignedTechnician() {
        return assignedTechnician;
    }

    public TicketHashtags getTicketHashtags() {
        return ticketHashtags;
    }

    public ContactMethod getContactMethodToUpdateClient() {
        return contactMethodToUpdateClient;
    }

    public LocalDateTime getTicketCreationDate() {
        return ticketCreationDate;
    }

    public TicketDeadline getTicketDeadline() {
        return ticketDeadline;
    }

    public List<String> getTimeByState() {
        return timeByState;
    }

    public TicketHistory getTicketHistory() {
        return ticketHistory;
    }
}
