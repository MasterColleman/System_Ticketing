package com.sergio.TicketSystemApp.views.ticketInfo;

import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.views.ticketCreation.JPanelTicketCreate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketInfoListener implements ActionListener {
    private static TicketInfoListener instance;


    private TicketInfoListener() {
    }

    public static TicketInfoListener getInstance() {
        if (instance == null) instance = new TicketInfoListener();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Send": {
                Controller.getInstance().createTicket(JPanelTicketCreate.getInstance().getTicket(),
                                                      JPanelTicketCreate.getInstance().getDescription());
            }
        }
    }

}
