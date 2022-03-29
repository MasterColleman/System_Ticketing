package com.sergio.TicketSystemApp.views.ticketSystem.components.TicketSystemPassword;

import com.sergio.TicketSystemApp.views.ticketSystem.TicketSystemListener;

import javax.swing.*;
import java.awt.Cursor;

public class JDialogTicketSystemPassword extends JDialog {


    private JPasswordField passwordField;
    private JPanel panelContent;
    private JLabel lblTitle;
    private JLabel lblSubtitle;
    private JLabel lblPassword;
    private JLabel lblSignIn;

    private static JDialogTicketSystemPassword instance;

    public JDialogTicketSystemPassword() {
        setModal(true);
        setTitle("Password");
        setSize(500, 300);
        setContentPane(panelContent);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static JDialogTicketSystemPassword getInstance() {
        if (instance == null) {
            instance = new JDialogTicketSystemPassword();
        }
        return instance;
    }

    private void initComponents() {
        lblSignIn.addMouseListener(TicketSystemListener.getInstance());
        lblSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblSignIn.setName("btnSigIn");
    }

    public static void main(String[] args) {
        JDialogTicketSystemPassword dialog = new JDialogTicketSystemPassword();
        dialog.setVisible(true);
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
