package com.sergio.TicketSystemApp.views.ticketSystem;

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
        }
    }
}
