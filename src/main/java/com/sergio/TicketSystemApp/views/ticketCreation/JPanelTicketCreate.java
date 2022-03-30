package com.sergio.TicketSystemApp.views.ticketCreation;

import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket.JPanelEditTicket;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
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

    private com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket.JPanelEditTicket JPanelEditTicket;

    private static JPanelTicketCreate instance;

    public JPanelTicketCreate() {
        this.setContentPane(contentPane);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fillComboBox();

        txtPhone.setInputVerifier(new InputVerifier() {
            public boolean verify(JComponent input) {
                JTextField tf = (JTextField) input;
                String cadena = tf.getText();
                return cadena.matches("^\\d{10}$");
            }
        });

        btnSend.addActionListener(TicketCreateListener.getInstance());
        btnSend.setActionCommand("send");
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
        return !txtName.getText().isEmpty() && txtEmail.getText()
            .matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") && !txtEmail.getText()
            .isEmpty() && txtPhone.getText().matches("^3[0-9]{9}$") && !txtPhone.getText()
            .isEmpty() && !txtTitle.getText().isEmpty() && !Objects.requireNonNull(cmbType.getSelectedItem()).toString()
            .isEmpty() && !txaDescription.getText().isEmpty() && !Objects.requireNonNull(
            cmbResponseType.getSelectedItem()).toString().isEmpty() && termsCheckBox.isSelected();
    }


    public void sendTicket() {
        if (validateFields()) {
            JOptionPane.showMessageDialog(this, "Ticket created successfully");
        } else JOptionPane.showMessageDialog(this, "Please fill all the fields correctly");
    }

    public static JPanelTicketCreate getInstance() {
        if (instance == null) {
            instance = new JPanelTicketCreate();
        }
        return instance;
    }


    public Ticket getTicket() {
        return new Ticket("", (TicketServiceType) cmbType.getSelectedItem(), new TicketStatus(), txtTitle.getText(),
                          txtName.getText(), txtEmail.getText(), txtPhone.getText(),
                          (ContactMethod) cmbResponseType.getSelectedItem(), new TicketPriority(),
                          AssignedTechnician.AgentOne, new TicketHashtags(),
                          (ContactMethod) cmbResponseType.getSelectedItem(), null, null, null, new TicketHistory());
    }

    public void showErrorMessage(String error, String message) {
        JOptionPane.showMessageDialog(this, error, message, JOptionPane.ERROR_MESSAGE);
    }

    public void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtTitle.setText("");
        cmbType.setSelectedIndex(0);
        txaDescription.setText("");
        cmbResponseType.setSelectedIndex(0);
        termsCheckBox.setSelected(false);
    }

    public void close() {
        this.dispose();
    }

    public List<String> getDescription() {
        return List.of(txtTitle.getText(), txaDescription.getText(),
                       txtEmail.getText());
    }

    public void getInfoEdit() {

    }


}
