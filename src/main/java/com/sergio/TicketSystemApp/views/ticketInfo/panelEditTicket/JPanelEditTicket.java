package com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket;

import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardResponse;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardTicket;
import com.sergio.TicketSystemApp.views.ticketInfo.components.RectInfo;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.sergio.TicketSystemApp.utils.StringUtils.toHtml;

public class JPanelEditTicket extends JDialog {

    private JPanel panelTitle;
    private JPanel panelStates;
    private JPanel panelInfoTicket;
    private JPanel panelUpdateTicket;
    private JPanel panelBoxes;
    private JScrollPane scroll;
    private JPanel content;
    private JComboBox<PriorityType> cmbPrioriry;
    private JComboBox<TicketServiceType> cmbType;
    private JComboBox<AssignedTechnician> cmbAsigned;
    private JComboBox<StateType> cmbState;
    private JComboBox<ContactMethod> cmbContact;
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
    private JButton actualizarTiempoButton;
    private JPanel panelDescription;
    private JButton btnUpdate;
    private JPanel panelCliente;
    private JPanel panelFecha;
    private JPanel panelEmail;
    private JPanel panelPriority;
    private JPanel panelNumber;
    private JPanel panelSource;
    private JPanel panelAsigned;
    private JPanel panelTipo;
    private JPanel panelEtiquetas;
    private JPanel panelUAsig;
    private JPanel panelUTipo;
    private JPanel jpanelUContact;
    private JPanel panelUState;
    private JPanel panelUPrority;
    private JPanel panelUHastags;
    private JPanel panelUTiempos;
    private JPanel panelUPlazo;
    private JPanel panelUFecha;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    private static JPanelEditTicket instance;
    private Map<String, RectInfo> states;

    private JCardTicket card;
    private List<JCardResponse> responses;

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
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 100,
                Toolkit.getDefaultToolkit().getScreenSize().height - 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(false);
    }

    private void initComponents() {
        this.setContentPane(scroll);
        scroll.setViewportView(content);


        // set all background to white
        content.setBackground(Color.WHITE);
        panelTitle.setBackground(Color.WHITE);
        panelStates.setBackground(Color.WHITE);
        panelInfoTicket.setBackground(Color.WHITE);
        panelUpdateTicket.setBackground(Color.WHITE);
        panelBoxes.setBackground(Color.WHITE);
        panelCard.setBackground(Color.WHITE);
        panelResponses.setBackground(Color.WHITE);
        panelDescription.setBackground(Color.WHITE);
        panelCliente.setBackground(Color.WHITE);
        panelFecha.setBackground(Color.WHITE);
        panelEmail.setBackground(Color.WHITE);
        panelPriority.setBackground(Color.WHITE);
        panelNumber.setBackground(Color.WHITE);
        panelSource.setBackground(Color.WHITE);
        panelAsigned.setBackground(Color.WHITE);
        panelTipo.setBackground(Color.WHITE);
        panelEtiquetas.setBackground(Color.WHITE);
        panelUAsig.setBackground(Color.WHITE);
        panelUTipo.setBackground(Color.WHITE);
        jpanelUContact.setBackground(Color.WHITE);
        panelUState.setBackground(Color.WHITE);
        panelUPrority.setBackground(Color.WHITE);
        panelUHastags.setBackground(Color.WHITE);
        panelUTiempos.setBackground(Color.WHITE);
        panelUPlazo.setBackground(Color.WHITE);
        panelUFecha.setBackground(Color.WHITE);


        // set text area border to black
        txaEliminated.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaFinished.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaCita.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaDiagnostico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaState.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        cmbPrioriry.addItem(PriorityType.urgent);
        cmbPrioriry.addItem(PriorityType.high);
        cmbPrioriry.addItem(PriorityType.medium);
        cmbPrioriry.addItem(PriorityType.low);

        cmbType.addItem(TicketServiceType.technicalService);
        cmbType.addItem(TicketServiceType.technicalSupport);
        cmbType.addItem(TicketServiceType.micro_Consulting);
        cmbType.addItem(TicketServiceType.assembly);

        cmbAsigned.addItem(AssignedTechnician.AgentOne);
        cmbAsigned.addItem(AssignedTechnician.AgentTwo);
        cmbAsigned.addItem(AssignedTechnician.AgentThree);
        cmbAsigned.addItem(AssignedTechnician.AgentFour);
        cmbAsigned.addItem(AssignedTechnician.AgentFive);

        cmbState.addItem(StateType.openByUser);
        cmbState.addItem(StateType.awaitingAssignmentAndResponse);
        cmbState.addItem(StateType.atReceptionDiagnosis);
        cmbState.addItem(StateType.inProcessing);
        cmbState.addItem(StateType.inTestingReview);
        cmbState.addItem(StateType.concluded);

        cmbContact.addItem(ContactMethod.ticketSystem);
        cmbContact.addItem(ContactMethod.whatsApp);
        cmbContact.addItem(ContactMethod.email);
        cmbContact.addItem(ContactMethod.phoneCall);
        cmbContact.addItem(ContactMethod.inPerson);
        cmbContact.addItem(ContactMethod.homeDelivery);

        lblTotalTime.setText("Tiempo Total: " );
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panelStates = new JPanel();
        panelStates.setLayout(new GridLayout(1, 6));
        panelStates.setBackground(Color.WHITE);

        states = new LinkedHashMap<>();
        states.put("Open", new RectInfo(toHtml("Abierto por el \nAdministrador"), new Color(0xFFCCCC)));
        states.put("Waiting", new RectInfo(toHtml("En espera de \nAsignacion y de\nRespuesta"), new Color(0xF8CBAD)));
        states.put("Diagnostic", new RectInfo(toHtml("En Recepcion /\nDiagnostico"), new Color(0xFFE699)));
        states.put("Process", new RectInfo(toHtml("En Procesamiento"), new Color(0xBDD7EE)));
        states.put("Testing", new RectInfo(toHtml("En Testeo /\nRevisión"), new Color(0xCCCCFF)));
        states.put("Concluded", new RectInfo(toHtml("Concluido"), new Color(0xA8E867)));

        for (String key : states.keySet()) {
            panelStates.add(states.get(key));
        }

        panelCard = new JPanel();
        card = new JCardTicket();
        panelCard.add(card);

        panelResponses = new JPanel();
        panelResponses.setLayout(new BoxLayout(panelResponses, BoxLayout.Y_AXIS));


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
        lblIdTicket.setText("Ticket: " + ticket.getTicketNumber());
        lblStateTicket.setText("Estado del Ticket:" + ticket.getTicketStatus().getActualState().getStateType());
        panelResponses.removeAll();
        setCard(ticket);
        setResponses(ticket);
        enableState(ticket.getTicketStatus().getActualState());
        setTexts(ticket);
        lblTotalTime.setText("Tiempo Total: " + ticket.getTotalTime());
    }

    private void setTexts(Ticket ticket) {
        lblName.setText(ticket.getClientName());
        lblEmail.setText(ticket.getClientEmail());
        lblNumber.setText(ticket.getClientCellPhoneNumber());
        lblSource.setText(ticket.getSourceRequest().getContactMethod());
        lblPriority.setText(ticket.getTicketPriority().getPriority().getPriorityType());
        lblType.setText(ticket.getTicketServiceType().getTicketServiceType());
        lblAsigned.setText(ticket.getAssignedTechnician().getAssignedTechnician());
        lblCreationDate.setText(ticket.getTicketCreationDate().toString());
        lblHastTags.setText(ticket.getTicketHashtags().getHashtags());
    }

    public void setCard(Ticket ticket) {
        ItemReplicaBox item = ticket.getTicketHistory().getListItemReplicaBoxes().get(0);
        card.setSizetxtArea(new Dimension(getWidth() - 200, 100));
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
            response.setTitleResponse(item.getBoxTitle(), item.getBoxTitleDescription(), item.getBoxSubtitle(),
                                      item.getBoxNewsDateAndTime());
            response.setContentResponse(item.getBoxContent());
            panelResponses.add(response);
        }
    }

    public static void main(String[] args) {
        JPanelEditTicket jPanelEditTicket = new JPanelEditTicket();
        jPanelEditTicket.setVisible(true);
    }
}
