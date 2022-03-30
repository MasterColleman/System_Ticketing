package com.sergio.TicketSystemApp.model;

import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TicketHistory {

    //private ItemReplicaBox ticketDescription;
    private ItemReplicaBox itemReplicaBox;
    private ArrayList<ItemReplicaBox> listItemReplicaBoxes;
    private int newsCount;

    public TicketHistory() {
        listItemReplicaBoxes = new ArrayList<>();
    }

    //Metodo para Añadir Descripcion del Ticket
    public void addDescription(String boxSubtitle, String boxContent, String clientName, ContactMethod sourceRequest,
                               String detailSourceRequest){/*detailSourceRequest es el correo, telefono o medio en
                                                            cuestion usado por el usuario para abrir ticket*/
        ItemReplicaBox description = new ItemReplicaBox();
        description.setBoxTitle("Tiquete Abierto - Descripcion del Caso");
        description.setBoxSubtitle(boxSubtitle);//Aqui va el titulo del ticket
        description.setBoxTitleDescription(clientName + " abrió ticket por " + String.valueOf(sourceRequest) + ". ");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    //Metodo para Agregar Respuesta al cliente del Ticket
    public void addResponse( AssignedTechnician assignedTechnician, String boxContent, String clientName,
                               ContactMethod sourceRequest, String detailSourceRequest){
        ItemReplicaBox response = new ItemReplicaBox();
        String agentName = String.valueOf(assignedTechnician);
        response.setBoxTitle(agentName + "en respuesta a" + clientName);
        response.setBoxSubtitle("Respuesta #" + newsCount++);
        response.setBoxTitleDescription(agentName + " respondiendo por " + String.valueOf(sourceRequest) + ". " +
                agentName + " a " + detailSourceRequest + ".");
        response.setBoxNewsDateAndTime();
        response.setBoxContent(boxContent);
        listItemReplicaBoxes.add(response);
    }

    //Metodo para Agregar Pregunta, Inquietud o solicitud nueva del cliente del Ticket
    public void addMessage( String boxTitle, String boxSubtitle, String boxContent, String clientName, ContactMethod sourceRequest,
                               String detailSourceRequest ){
        ItemReplicaBox description = new ItemReplicaBox();
        description.setBoxTitle(boxTitle + " #" + newsCount++); //Pregunta, Inquietud o Solicitud. DEJAR DESPLEGABLE AQUI
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo de lo que trata  dicha cuestion
        description.setBoxTitleDescription(clientName + " envia mensaje a Agente por " + String.valueOf(sourceRequest) + ". " +
                clientName + " a " + detailSourceRequest + ".");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    //Metodo para Agregar Actualizacion del Ticket
    public void addUpdate( AssignedTechnician assignedTechnician, String boxSubtitle, String boxContent ){
        ItemReplicaBox description = new ItemReplicaBox();
        String agentName = String.valueOf(assignedTechnician);
        description.setBoxTitle("Actualizacion #" + newsCount++);
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo de la actualizacion del ticket
        description.setBoxTitleDescription(agentName + " crea actualizacion del ticket por sistema. ");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    //Metodo para Agregar Actualizacion de Estado del Ticket
    //changeStateAuto() se ejecuta antes, en Ticket o TicketManager
    public void addStateUpdate( AssignedTechnician assignedTechnician, String boxSubtitle, String boxContent, TicketStatus ticketStatus ){
        ItemReplicaBox description = new ItemReplicaBox();
        String agentName = String.valueOf(assignedTechnician);
        String state = changeState(ticketStatus);
        description.setBoxTitle("Actualizacion a Estado: " + state );//Cambiar color en barra de estado y en esta caja
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo de la actualizacion de estado del ticket
        description.setBoxTitleDescription(agentName + " cambia estado del ticket por sistema. ");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    public String changeState(TicketStatus ticketStatus){
        StateType state = ticketStatus.getActualState();
        switch (state) {
            case openByUser -> state = StateType.awaitingAssignmentAndResponse;
            case awaitingAssignmentAndResponse -> state = StateType.atReceptionDiagnosis;
            case atReceptionDiagnosis -> state = StateType.inProcessing;
            case inProcessing -> state = StateType.inTestingReview;
            case inTestingReview -> state = StateType.concluded;
        }
        return String.valueOf(state);
    }

    //Metodo para Agregar y Fijar un cita por calendario con el cliente
    public void addCalendarAppointment(AssignedTechnician assignedTechnician, String boxSubtitle, String boxContent, TicketStatus ticketStatus,
                                       @NotNull LocalDateTime dateTimeCalendar){
        ItemReplicaBox description = new ItemReplicaBox();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d ' de ' M ' de ' yyyy. ' A las ' kk .");
        String agentName = String.valueOf(assignedTechnician);
        String state = String.valueOf(ticketStatus);
        description.setBoxTitle("Creacion de cita con el cliente #" + newsCount++);
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo del porque la creacion de una fecha de reunion con el cliente
        description.setBoxTitleDescription(agentName + " crea y concerta cita con el ciente el dia: " + dateTimeCalendar.format(formatter) );
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    //Metodo para Agregar Finalizacion del ticket
    //addStateUpdate(...) se ejecuta despues de este metodo ya que vendria a ser el estado concluido, en Ticket o TicketManager
    public void addConclusion(AssignedTechnician assignedTechnician, String boxSubtitle, String boxContent){
        ItemReplicaBox description = new ItemReplicaBox();
        String agentName = String.valueOf(assignedTechnician);
        description.setBoxTitle("Conclusion o Finalizacion de Ticket");
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo de la conclusion del ticket
        description.setBoxTitleDescription(agentName + " Explica la finalizacion del ticket por sistema. ");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);//Explica resultados y conclusiones del caso y la fecha que se concerta para entregar el servicio
        listItemReplicaBoxes.add(description);
    }

    //Metodo para mandar mensaje de alerta de eliminacion del ticket
    //eliminateTicket(...) se ejecuta 1dia despues de este metodo
    public void addTicketDelete(AssignedTechnician assignedTechnician, String boxSubtitle, String boxContent){
        ItemReplicaBox description = new ItemReplicaBox();
        String agentName = String.valueOf(assignedTechnician);
        description.setBoxTitle("Eliminacion de Ticket: " );//Cambiar a color Rojo Claro esta caja
        description.setBoxSubtitle(boxSubtitle);//Aqui va el Titulo del la eliminacion del ticket
        description.setBoxTitleDescription(agentName + " a punto de ejecutar eliminacion del ticket por sistema. ");
        description.setBoxNewsDateAndTime();
        description.setBoxContent(boxContent);
        listItemReplicaBoxes.add(description);
    }

    public void setListItemReplicaBoxes(ArrayList<ItemReplicaBox> listItemReplicaBoxes) {
        this.listItemReplicaBoxes = listItemReplicaBoxes;
    }

    public ArrayList<ItemReplicaBox> getListItemReplicaBoxes() {
        return listItemReplicaBoxes;
    }

}
