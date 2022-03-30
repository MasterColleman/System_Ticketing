package com.sergio.TicketSystemApp.views.home;

import com.sergio.TicketSystemApp.views.ticketCreation.JPanelTicketCreate;
import com.sergio.TicketSystemApp.views.ticketInfo.JPanelTicketInfo;
import com.sergio.TicketSystemApp.views.ticketInfo.dialogSearchTicket.JDialogSearchTicket;
import com.sergio.TicketSystemApp.views.ticketSystem.JPanelTicketSystem;

import javax.swing.*;
import java.awt.*;

public class JPanelHome extends JFrame {
    private JPanel panelHome;
    private JLabel lblTitle;
    private JLabel lblSubtitle;

    private JLabel lblSystem;
    private JLabel lblCreate;
    private JLabel lblView;
    private static JPanelHome instance;

    private JPanelTicketSystem panelTicketSystem;
    private JPanelTicketCreate panelTicketCreate;
    private JDialogSearchTicket panelTicketInfo;


    public JPanelHome() {
        instance = this;
        setTitle("Home");
        setSize(400, 290);
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static JPanelHome getInstance() {
        if (instance == null) {
            instance = new JPanelHome();
        }
        return instance;
    }

    public void initComponents() {
        this.setContentPane(panelHome);
        lblSystem.setName("btnSystem");
        lblCreate.setName("btnCreate");
        lblView.setName("btnView");

        lblSystem.addMouseListener(HomeListener.getInstance());
        lblCreate.addMouseListener(HomeListener.getInstance());
        lblView.addMouseListener(HomeListener.getInstance());

        lblSystem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblCreate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblView.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public JLabel getLblSystem() {
        return lblSystem;
    }

    public JLabel getLblCreate() {
        return lblCreate;
    }

    public JLabel getLblView() {
        return lblView;
    }

    public static void main(String[] args) {
        JPanelHome panelHome = new JPanelHome();
    }

    public void setVisibleSystemPanel() {
        panelTicketSystem = JPanelTicketSystem.getInstance();
        panelTicketSystem.showDialogTicketSystemPassword();
    }

    public void setVisibleCreatePanel() {
        panelTicketCreate = JPanelTicketCreate.getInstance();
        panelTicketCreate.setVisible(true);
    }

    public void setVisibleSearchPanel() {
        panelTicketInfo = JDialogSearchTicket.getInstance();
        panelTicketInfo.setVisible(true);
    }
}
