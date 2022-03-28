package com.sergio.TicketSystemApp.views.ticketInfo;

import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardResponse;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardTicket;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class JPanelTicketInfo extends JFrame {
    private JPanel content;
    private JLabel lblOpe;
    private JPanel statesPanel;
    private JPanel infoPanel;
    private JPanel cardPanel;
    private JPanel responsesPanel;
    private JPanel contentPanel;
    private JScrollPane scrollContentPanel;
    private static JPanelTicketInfo instance;

    private JCardTicket card;
    private List<JCardResponse> responses;

    public JPanelTicketInfo() {
        setContentPane(content);
        setTitle("Ticket Info");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        card.setSizetxtArea(new Dimension(getWidth()-50,100));
        setVisible(true);
    }


    public static JPanelTicketInfo getInstance() {
        if (instance == null) {
            new JPanelTicketInfo();
        }
        return instance;
    }

    public static void main(String[] args) {
        JPanelTicketInfo panel = JPanelTicketInfo.getInstance();
    }

    private void createUIComponents() {
        cardPanel = new JPanel();
        card = new JCardTicket();
        card.setTitle("Ticket", "Ticket", "tupo", "alibaba", LocalDateTime.now());
        cardPanel.add(card);

//        List<Object> rs = Controller.getInstance().getResponsesFromTicket(/* TODO: ticket*/ "1");
//        rs.stream().map(r -> new JCardResponse()).forEach(response -> responses.add(response));
//        responses.forEach(response -> responsesPanel.add(response));
    }
}