package com.sergio.TicketSystemApp.views.ticketSystem;


import com.sergio.TicketSystemApp.views.ticketSystem.components.TicketSystemPassword.JDialogTicketSystemPassword;

import javax.swing.*;

public class JPanelTicketSystem extends JFrame {
    private JPanel panelTicketSystem;
    private JDialogTicketSystemPassword dialogTicketSystemPassword;
    private static JPanelTicketSystem instance;

    public JPanelTicketSystem() {
        instance = this;
        dialogTicketSystemPassword = JDialogTicketSystemPassword.getInstance();
        setSize(600, 400);
        setContentPane(panelTicketSystem);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ticket System");
    }

    public static JPanelTicketSystem getInstance() {
        if (instance == null) {
            instance = new JPanelTicketSystem();
        }
        return instance;
    }

    public void showDialogTicketSystemPassword() {
        dialogTicketSystemPassword.setVisible(true);
    }

    public void hideDialogTicketSystemPassword() {
        dialogTicketSystemPassword.setVisible(false);
    }

    public void sigIn() {
        String password = dialogTicketSystemPassword.getPassword();
        System.out.println(password);
        // TODO: Check password
        if (password.equals("admin")) {
            hideDialogTicketSystemPassword();
            setVisible(true);
            System.out.println("SigIn");
        } else {
            JOptionPane.showMessageDialog(this, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
