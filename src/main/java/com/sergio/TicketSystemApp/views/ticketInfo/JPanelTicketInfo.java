package com.sergio.TicketSystemApp.views.ticketInfo;

import com.sergio.TicketSystemApp.model.ItemReplicaBox;
import com.sergio.TicketSystemApp.model.StateType;
import com.sergio.TicketSystemApp.model.Ticket;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardResponse;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardTicket;
import com.sergio.TicketSystemApp.views.ticketInfo.components.RectInfo;
import com.sergio.TicketSystemApp.views.ticketInfo.dialogSearchTicket.JDialogSearchTicket;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static com.sergio.TicketSystemApp.utils.StringUtils.toHtml;

public class JPanelTicketInfo extends JFrame {
    private JPanel content;

    private JPanel statesPanel;
    private JPanel infoPanel;
    private JPanel cardPanel;
    private JPanel responsesPanel;
    private JPanel contentPanel;
    private JScrollPane scrollContentPanel;
    private JLabel idTicket;
    private JLabel stateTicket;
    private JLabel titleTicket;
    private JButton editarButton;
    private static JPanelTicketInfo instance;
    private JDialogSearchTicket searchTicket;

    private JCardTicket card;
    private List<JCardResponse> responses;
    private HashMap<String, RectInfo> states;
    private Ticket ticket;


    public JPanelTicketInfo() {
        setContentPane(content);
        setTitle("Ticket Info");
        setSize(900, 600);
        setBackground(Color.WHITE);
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(4)));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        card.setSizetxtArea(new Dimension(getWidth() - 200, 100));
        infoPanel.setBackground(Color.WHITE);
        statesPanel.setBackground(Color.WHITE);
        responsesPanel.setBackground(Color.WHITE);
        contentPanel.setBackground(Color.WHITE);
        scrollContentPanel.setBackground(Color.WHITE);
        cardPanel.setBackground(Color.WHITE);
        card.setBackground(Color.WHITE);
        scrollContentPanel.setBorder(null);
        editarButton.addActionListener(TicketInfoListener.getInstance());
        editarButton.setActionCommand("Edit");
        setVisible(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static JPanelTicketInfo getInstance() {
        if (instance == null) {
            instance = new JPanelTicketInfo();

        }
        return instance;
    }

    public void enableState(StateType stateType) {
        switch (stateType) {
            case openByUser -> enableStateI("Open");
            case awaitingAssignmentAndResponse -> enableStateI("Waiting");
            case atReceptionDiagnosis -> enableStateI("Diagnostic");
            case inProcessing -> enableStateI("Process");
            case inTestingReview -> enableStateI("Testing");
            case concluded -> enableStateI("Concluded");
        }
    }

    private void enableStateI(String state) {
        states.values().forEach(RectInfo::disableComponent);
        states.get(state).enableComponent();
    }

    public void setUpCard(Ticket ticket) {
        this.ticket = ticket;
        titleTicket.setText("Titulo del Ticket: " + ticket.getTicketName());
        idTicket.setText("Ticket: " + ticket.getTicketNumber());
        stateTicket.setText("Estado del Ticket:" + ticket.getTicketStatus().getActualState().getStateType());
        responsesPanel.removeAll();
        setCard(ticket);
        setResponses(ticket);
        enableState(ticket.getTicketStatus().getActualState());
    }

    public void setCard(Ticket ticket) {
        ItemReplicaBox item = ticket.getTicketHistory().getListItemReplicaBoxes().get(0);
        card.setTitle(
            item.getBoxTitle(), item.getBoxTitleDescription(), item.getBoxSubtitle(), item.getBoxNewsDateAndTime());
        card.setContent(item.getBoxContent());
    }

    public void setResponses(Ticket ticket) {
        List<ItemReplicaBox> history = ticket.getTicketHistory().getListItemReplicaBoxes();
        List<ItemReplicaBox> items = history.subList(1, history.size());
        JCardResponse response;
        for (ItemReplicaBox item : items) {
            response = new JCardResponse();
            response.setSizetxtArea(new Dimension(getWidth() - 200, 100));
            response.setTitleResponse(item.getBoxTitle(),
                item.getBoxTitleDescription(), item.getBoxSubtitle(), item.getBoxNewsDateAndTime());
            response.setContentResponse(item.getBoxContent());
            responsesPanel.add(response);
        }
    }

    private void createUIComponents() {
        statesPanel = new JPanel();
        statesPanel.setLayout(new GridLayout(1, 6));
        statesPanel.setBackground(Color.WHITE);
        states = new LinkedHashMap<>();
        states.put("Open", new RectInfo(toHtml("Abierto por el \nAdministrador"), new Color(0xFFCCCC)));
        states.put("Waiting", new RectInfo(toHtml("En espera de \nAsignacion y de\nRespuesta"), new Color(0xF8CBAD)));
        states.put("Diagnostic", new RectInfo(toHtml("En Recepcion /\nDiagnostico"), new Color(0xFFE699)));
        states.put("Process", new RectInfo(toHtml("En Procesamiento"), new Color(0xBDD7EE)));
        states.put("Testing", new RectInfo(toHtml("En Testeo /\nRevisión"), new Color(0xCCCCFF)));
        states.put("Concluded", new RectInfo(toHtml("Concluido"), new Color(0xA8E867)));

        for (String key : states.keySet()) {
            statesPanel.add(states.get(key));
        }

        cardPanel = new JPanel();
        card = new JCardTicket();
        cardPanel.add(card);

        responsesPanel = new JPanel();
        responsesPanel.setLayout(new BoxLayout(responsesPanel,BoxLayout.Y_AXIS));


    }

    public Ticket getTicket() {
        return ticket;
    }

    public void disableEdit() {
        editarButton.setEnabled(false);
    }

    public void enableButton() {
        editarButton.setEnabled(true);
    }
}