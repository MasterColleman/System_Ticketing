package com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket;

import com.sergio.TicketSystemApp.model.PriorityType;

import javax.swing.*;
import java.awt.*;

public class JPanelEditTicket extends JDialog {

    private JPanel panelTitle;
    private JPanel panelStates;
    private JPanel panelInfoTicket;
    private JPanel panelUpdateTicket;
    private JPanel panelBoxes;
    private JScrollPane scroll;
    private JPanel content;
    private JComboBox<PriorityType> cmbPrioriry;
    private JComboBox cmbType;
    private JComboBox cmbAsigned;
    private JComboBox cmbState;
    private JComboBox cmbContact;
    private JTextArea txaEliminated;
    private JTextArea txaFinished;
    private JTextArea txaCita;
    private JTextArea txaDiagnostico;
    private JTextArea txaState;
    private JPanel panelCard;
    private JPanel panelResponses;
    private JLabel lblIdTicket;
    private JLabel lblStateTicket;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblNumber;
    private JLabel lblSource;
    private JLabel lblPriority;
    private JLabel lblDate;
    private JLabel lblAsigned;
    private JLabel lblHastTags;
    private JLabel lblType;
    private JLabel lblPlazo;
    private JLabel lblCreationDate;
    private JLabel timeOne;
    private JLabel timeTwo;
    private JLabel timeThree;
    private JLabel timeFour;
    private JLabel timeFive;
    private JLabel timeSix;
    private JLabel lblTotalTime;
    private JTextField textField1;
    private JButton actualizarButton;

    private static JPanelEditTicket instance;

    public static JPanelEditTicket getInstance() {
        if (instance == null) {
            instance = new JPanelEditTicket();
        }
        return instance;
    }

    public JPanelEditTicket() {
        setContentPane(scroll);
        setModal(true);
        setTitle("Editar Ticket");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panelStates = new JPanel();
        panelStates.setLayout(new GridLayout(1,6));

    }
}
