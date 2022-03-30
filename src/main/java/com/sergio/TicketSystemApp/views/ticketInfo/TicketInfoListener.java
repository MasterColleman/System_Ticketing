package com.sergio.TicketSystemApp.views.ticketInfo;

import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.model.Ticket;
import com.sergio.TicketSystemApp.views.ticketCreation.JPanelTicketCreate;
import com.sergio.TicketSystemApp.views.ticketInfo.dialogSearchTicket.JDialogSearchTicket;
import com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket.JPanelEditTicket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
            case "searchTicket" -> {
                searchTicket();
            }
            case "Send" -> {
                Controller.getInstance().createTicket(JPanelTicketCreate.getInstance().getTicket(),
                                                      JPanelTicketCreate.getInstance().getDescription());
            }
            case "Edit" -> {
                Ticket ticket = JPanelTicketInfo.getInstance().getTicket();
                JPanelEditTicket panel = JPanelEditTicket.getInstance();
                panel.setUpCard(ticket);
                panel.setVisible(true);
            }
            case "Update" -> {
                update();
            }
        }
    }

    private void update() {
        int type = JPanelEditTicket.getInstance().getTypeUpdate();
        if (type == 0) {
            List<String> data = JPanelEditTicket.getInstance().getDataType0();
            Controller.getInstance()
                .addMessageInTicketHistory(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));
        }
        if (type == 3) {
            List<String> data = JPanelEditTicket.getInstance().getDataType3();
            Controller.getInstance().addUpdateInTicketHistory(data.get(0), data.get(1), data.get(2));
        }
        if (type == 1) {
            List<String> data = JPanelEditTicket.getInstance().getDataType1();
            Controller.getInstance().addStateUpdateInTicketHistory(data.get(0), data.get(1), data.get(2));
        }
        if (type == 2) {
            List<String> data = JPanelEditTicket.getInstance().getDataType2();
            Controller.getInstance().addCalendarAppointmentInTicketHistory(data.get(0), data.get(1), data.get(2),
                                                                           LocalDateTime.parse(data.get(3),
                                                                                               DateTimeFormatter.ofPattern(
                                                                                                   "dd/MM/yyyy")));
        }
    }

    private void searchTicket() {
        Controller controller = Controller.getInstance();
        String id = JDialogSearchTicket.getInstance().getTicketId();
        if (id == null) return;
        Ticket ticket = controller.getTicket(id);
        if (ticket == null) {
            JOptionPane.showMessageDialog(null, "Ticket not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JDialogSearchTicket.getInstance().clearAndClose();
        JPanelTicketInfo.getInstance().setUpCard(ticket);
        JPanelTicketInfo.getInstance().disableEdit();
        JPanelTicketInfo.getInstance().setVisible(true);
    }

}
