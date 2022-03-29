package com.sergio.TicketSystemApp.views.ticketCreation;

import com.sergio.TicketSystemApp.model.ContactMethod;
import com.sergio.TicketSystemApp.model.StateType;
import com.sergio.TicketSystemApp.model.TicketServiceType;

import javax.swing.*;
import java.util.Objects;

public class JPanelTicketCreate extends JFrame {
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtTitle;
    private JComboBox<TicketServiceType> cmbType;
    private JTextArea txaDescription;
    private JComboBox<ContactMethod> cmbResponseType;
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
        fillComboBox();

        txtPhone.setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                JTextField tf = (JTextField) input;
                String cadena = tf.getText();
                return cadena.matches("^\\d{10}$");
            }
        });

        setVisible(true);

    }

    private void fillComboBox() {
        cmbType.addItem(TicketServiceType.technicalService);
        cmbType.addItem(TicketServiceType.assembly);
        cmbType.addItem(TicketServiceType.micro_Consulting);
        cmbType.addItem(TicketServiceType.technicalSupport);

        cmbResponseType.addItem(ContactMethod.email);
        cmbResponseType.addItem(ContactMethod.ticketSystem);
        cmbResponseType.addItem(ContactMethod.homeDelivery);
        cmbResponseType.addItem(ContactMethod.whatsApp);
        cmbResponseType.addItem(ContactMethod.phoneCall);
        cmbResponseType.addItem(ContactMethod.inPerson);
    }

    public boolean validateFields() {
        //regex for email -> ^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$
        //regex for phone -> ^[0-9]{9}$
        return !txtName.getText().isEmpty() && txtEmail.getText()
            .matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") && !txtEmail.getText()
            .isEmpty() && txtPhone.getText().matches("^[0-9]{9}$") && !txtPhone.getText()
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
