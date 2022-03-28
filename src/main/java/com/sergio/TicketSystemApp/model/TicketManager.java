package com.sergio.TicketSystemApp.model;

import java.util.ArrayList;

public class TicketManager {

    private ArrayList<Ticket> ticketsList;

    public TicketManager() {
        ticketsList = new ArrayList<>();
    }

    public ArrayList<Ticket> getTicketsList() {
        return this.ticketsList;
    }

    public void setListCustomers(ArrayList<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public void addTicket(Ticket ticket){

    }

    //Metodos
}
