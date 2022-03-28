package com.sergio.TicketSystemApp.views.ticketInfo.dialogSearchTicket;

import javax.swing.*;
import java.awt.*;

public class JDialogSearchTicket extends JDialog {
    private JPanel contentPanel;
    private JTextField txtNumber;

    public JDialogSearchTicket() {
        contentPanel.setBackground(Color.WHITE);
        txtNumber.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2),Color.BLUE));
        setContentPane(contentPanel);
        setModal(true);
        setTitle("Search Ticket");
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JDialogSearchTicket dialog = new JDialogSearchTicket();
        dialog.setVisible(true);
    }
}
