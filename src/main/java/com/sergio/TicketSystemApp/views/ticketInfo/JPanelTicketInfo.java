package com.sergio.TicketSystemApp.views.ticketInfo;

import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardResponse;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardTicket;
import com.sergio.TicketSystemApp.views.ticketInfo.components.RectInfo;

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
//    private JDialogSearchTicket searchTicket;

    private JCardTicket card;
    private List<JCardResponse> responses;
    private HashMap<String, RectInfo> states;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SERGIO
    private JComboBox<PriorityType> cmbPriorityType;
    private JComboBox<TicketServiceType> cmbServiceType;
    private JComboBox<AssignedTechnician> cmbAgentType;
    private JComboBox<StateType> cmbStateType;
    private JComboBox<ContactMethod> cmbContactMethod;
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SERGIO

    public JPanelTicketInfo() {
        setContentPane(content);
        setTitle("Ticket Info");
        setSize(900, 600);
        setBackground(Color.WHITE);
        content.setBackground(Color.WHITE);
        content.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(4)));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        card.setSizetxtArea(new Dimension(getWidth() - 50, 100));
        infoPanel.setBackground(Color.WHITE);
        statesPanel.setBackground(Color.WHITE);
        responsesPanel.setBackground(Color.WHITE);
        contentPanel.setBackground(Color.WHITE);
        scrollContentPanel.setBackground(Color.WHITE);
        cardPanel.setBackground(Color.WHITE);
        card.setBackground(Color.WHITE);
        scrollContentPanel.setBorder(null);
        editarButton.addActionListener(TicketInfoListener.getInstance());
        setVisible(false);

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SERGIO
    private void fillComboBox() {
        cmbPriorityType.addItem(PriorityType.urgent);
        cmbPriorityType.addItem(PriorityType.high);
        cmbPriorityType.addItem(PriorityType.medium);
        cmbPriorityType.addItem(PriorityType.low);

        cmbServiceType.addItem(TicketServiceType.technicalService);
        cmbServiceType.addItem(TicketServiceType.technicalSupport);
        cmbServiceType.addItem(TicketServiceType.micro_Consulting);
        cmbServiceType.addItem(TicketServiceType.assembly);

        cmbAgentType.addItem(AssignedTechnician.AgentOne);
        cmbAgentType.addItem(AssignedTechnician.AgentTwo);
        cmbAgentType.addItem(AssignedTechnician.AgentThree);
        cmbAgentType.addItem(AssignedTechnician.AgentFour);
        cmbAgentType.addItem(AssignedTechnician.AgentFive);

        cmbStateType.addItem(StateType.openByUser);
        cmbStateType.addItem(StateType.awaitingAssignmentAndResponse);
        cmbStateType.addItem(StateType.atReceptionDiagnosis);
        cmbStateType.addItem(StateType.inProcessing);
        cmbStateType.addItem(StateType.inTestingReview);
        cmbStateType.addItem(StateType.concluded);

        cmbContactMethod.addItem(ContactMethod.ticketSystem);
        cmbContactMethod.addItem(ContactMethod.whatsApp);
        cmbContactMethod.addItem(ContactMethod.email);
        cmbContactMethod.addItem(ContactMethod.phoneCall);
        cmbContactMethod.addItem(ContactMethod.inPerson);
        cmbContactMethod.addItem(ContactMethod.homeDelivery);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SERGIO

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
            response.setSizetxtArea(new Dimension(getWidth() - 50, 100));
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
}