package com.sergio.TicketSystemApp.views.ticketCreation;

import javax.swing.*;
import java.util.Objects;

public class JPanelTicketCreate extends JFrame {
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtTitle;
    private JComboBox cmbType;
    private JTextArea txaDescription;
    private JComboBox cmbResponseType;
    private JCheckBox termsCheckBox;
    private javax.swing.JPanel JPanelCase;
    private JPanel contentPane;
    private JButton btnSend;
    private JPanel JPanelData;
    private JPanel JPanelDescription;

    private static JPanelTicketCreate instance;

    public JPanelTicketCreate() {
        this.setContentPane(contentPane);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);

    }

    public boolean validateFields() {
        return !txtName.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtPhone.getText()
            .isEmpty() && !txtTitle.getText().isEmpty() && !Objects.requireNonNull(cmbType.getSelectedItem()).toString()
            .isEmpty() && !txaDescription.getText().isEmpty() && !Objects.requireNonNull(
            cmbResponseType.getSelectedItem()).toString().isEmpty() && termsCheckBox.isSelected();
    }


    public void sendTicket() {
    }

    public static JPanelTicketCreate getInstance() {
        if (instance == null) {
            instance = new JPanelTicketCreate();
        }
        return instance;
    }

    public static void main(String[] args) {
        JPanelTicketCreate frame = new JPanelTicketCreate();

    }

    public Object getTicket() {
        // TODO create ticket from form
        return null;
    }
}
