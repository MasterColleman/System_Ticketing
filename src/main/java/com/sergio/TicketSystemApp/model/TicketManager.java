package com.sergio.TicketSystemApp.model;

import com.sergio.TicketSystemApp.controllers.Controller;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private static TicketManager instance;

    private ArrayList<Ticket> ticketsList;

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

    public void addTicket(Ticket ticket) {
        ticketsList.add(ticket);
        System.out.println(ticketsList);
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

    //Metodos
}
