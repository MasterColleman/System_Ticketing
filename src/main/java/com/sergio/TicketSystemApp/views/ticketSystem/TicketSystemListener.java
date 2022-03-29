package com.sergio.TicketSystemApp.views.ticketSystem;

import com.sergio.TicketSystemApp.model.Ticket;
import com.sergio.TicketSystemApp.views.ticketInfo.JPanelTicketInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicketSystemListener extends MouseAdapter {
    private static TicketSystemListener instance;

    private TicketSystemListener() {}

    public static TicketSystemListener getInstance() {
        if (instance == null) {
            instance = new TicketSystemListener();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "btnSigIn" -> JPanelTicketSystem.getInstance().sigIn();
            case "btnClickTickets" -> openInfoTicket(JPanelTicketSystem.getInstance().getTicket());
        }
    }

    private void openInfoTicket(Ticket ticket) {
        JPanelTicketInfo info = JPanelTicketInfo.getInstance();
        info.setUpCard(ticket);
        info.enableButton();
        info.setVisible(true);
    }
}
