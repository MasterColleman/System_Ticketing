package com.sergio.TicketSystemApp.views.ticketInfo.dialogSearchTicket;

import com.sergio.TicketSystemApp.views.ticketInfo.TicketInfoListener;

import javax.swing.*;
import java.awt.*;

public class JDialogSearchTicket extends JDialog {
    private JPanel contentPanel;
    private JTextField txtNumber;
    private JButton btnSearch;

    private static JDialogSearchTicket instance;

    public JDialogSearchTicket() {
        contentPanel.setBackground(Color.WHITE);
        txtNumber.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2), Color.BLUE));
        setContentPane(contentPanel);
        setModal(true);
        setTitle("Search Ticket");
        setSize(400, 300);
        setLocationRelativeTo(null);
        btnSearch.addActionListener(TicketInfoListener.getInstance());
        btnSearch.setActionCommand("searchTicket");
        setVisible(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static JDialogSearchTicket getInstance() {
        if (instance == null) {
            instance = new JDialogSearchTicket();
        }
        return instance;
    }

    public String getTicketId() {
        if (txtNumber.getText().isEmpty()) JOptionPane.showMessageDialog(this, "Please enter a ticket number");
        else if (txtNumber.getText().contains("#")) return txtNumber.getText();
        else return "#" + txtNumber.getText();
        return null;
    }

    public void clearAndClose() {
        txtNumber.setText("");
        dispose();
    }
}
