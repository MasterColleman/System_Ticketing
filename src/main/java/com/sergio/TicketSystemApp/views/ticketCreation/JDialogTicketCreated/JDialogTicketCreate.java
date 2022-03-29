package com.sergio.TicketSystemApp.views.ticketCreation.JDialogTicketCreated;

import javax.swing.*;
import java.awt.*;

public class JDialogTicketCreate extends JDialog {
    private JPanel contentPanel;
    private JLabel lblIdTicket;
    private static JDialogTicketCreate instance;


    public JDialogTicketCreate() {
        contentPanel.setBackground(Color.WHITE);
        setContentPane(contentPanel);
        setModal(true);
        setResizable(false);
        setTitle("Ticket Created");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public static JDialogTicketCreate getInstance() {
        if (instance == null) {
            instance = new JDialogTicketCreate();
        }
        return instance;
    }


    public void setText(String lblIdTicket) {
        this.lblIdTicket.setText(lblIdTicket);
    }

    public static void main(String[] args) {
        JDialogTicketCreate dialog = new JDialogTicketCreate();
    }
}
