package com.sergio.TicketSystemApp.views.ticketCreation;

import com.sergio.TicketSystemApp.controllers.Controller;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketCreateListener implements ActionListener {
    private static TicketCreateListener instance = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("send")) {
            JPanelTicketCreate view = JPanelTicketCreate.getInstance();
            if(view.validateFields()){
                Controller.getInstance().createTicket(view.getTicket());
            }else {
                view.showErrorMessage("Error", "Please fill all the fields");
            }

        }
    }

    private TicketCreateListener() {

    }

    public static TicketCreateListener getInstance() {
        if (instance == null) {
            instance = new TicketCreateListener();
        }
        return instance;
    }
}
