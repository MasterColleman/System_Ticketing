package com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditTicketListener implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JPanelEditTicket.getInstance().isTextInField();
    }

    // singleton
    private static EditTicketListener instance;
    private EditTicketListener() {
    }
    public static EditTicketListener getInstance() {
        if (instance == null) {
            instance = new EditTicketListener();
        }
        return instance;
    }
}
