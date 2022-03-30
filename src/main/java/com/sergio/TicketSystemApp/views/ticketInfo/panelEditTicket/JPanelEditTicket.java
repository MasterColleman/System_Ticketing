package com.sergio.TicketSystemApp.views.ticketInfo.panelEditTicket;

import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.model.*;
import com.sergio.TicketSystemApp.views.ticketInfo.JPanelTicketInfo;
import com.sergio.TicketSystemApp.views.ticketInfo.TicketInfoListener;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardResponse;
import com.sergio.TicketSystemApp.views.ticketInfo.components.JCardTicket;
import com.sergio.TicketSystemApp.views.ticketInfo.components.RectInfo;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
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
    private JTextArea txaFinished;
    private JTextArea txaUpdateCase;
    private JTextArea txaCita;
    private JTextArea txaUpdateState;
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
    private JButton btnUpdateTime;
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

    private JTextField txtTitle;
    private JComboBox<ContactMethod> cmbUContact;
    private JTextField txtAgenteA;
    private JTextField txtUpdateState;
    private JTextField txtTitleCita;
    private JTextField txtFechaCita;
    private JTextField txtTitleUpdateCase;
    private JTextField txtTitleConclusion;
    private JPanel panelResp1;
    private JPanel panelResp2;
    private JPanel panelResp3;
    private JPanel panelResp4;
    private JPanel panelResp5;
    private JLabel citaTicket;
    private JLabel actTicket;

    private static JPanelEditTicket instance;
    private Map<String, RectInfo> states;

    private JCardTicket card;
    private List<JCardResponse> responses;
    private int typeUpdate;

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
        panelUPrority.setBackground(Color.WHITE);
        panelUHastags.setBackground(Color.WHITE);
        panelUTiempos.setBackground(Color.WHITE);
        panelUPlazo.setBackground(Color.WHITE);
        panelUFecha.setBackground(Color.WHITE);
        panelResp1.setBackground(Color.WHITE);
        panelResp2.setBackground(Color.WHITE);
        panelResp3.setBackground(Color.WHITE);
        panelResp4.setBackground(Color.WHITE);
        panelResp5.setBackground(Color.WHITE);


        // set border to panelResp to make it look like a card
        panelResp1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelResp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelResp3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelResp4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelResp5.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // set text area border to black
        txaFinished.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaUpdateCase.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaCita.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txaUpdateState.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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


        cmbContact.addItem(ContactMethod.ticketSystem);
        cmbContact.addItem(ContactMethod.whatsApp);
        cmbContact.addItem(ContactMethod.email);
        cmbContact.addItem(ContactMethod.phoneCall);
        cmbContact.addItem(ContactMethod.inPerson);
        cmbContact.addItem(ContactMethod.homeDelivery);

        cmbUContact.addItem(ContactMethod.ticketSystem);
        cmbUContact.addItem(ContactMethod.whatsApp);
        cmbUContact.addItem(ContactMethod.email);
        cmbUContact.addItem(ContactMethod.phoneCall);
        cmbUContact.addItem(ContactMethod.inPerson);
        cmbUContact.addItem(ContactMethod.homeDelivery);


        lblTotalTime.setText("Tiempo Total: ");

        // add KeyListener to text areas and text fields
        txaFinished.addKeyListener(EditTicketListener.getInstance());
        txaUpdateCase.addKeyListener(EditTicketListener.getInstance());
        txaCita.addKeyListener(EditTicketListener.getInstance());
        txaUpdateState.addKeyListener(EditTicketListener.getInstance());
        txaState.addKeyListener(EditTicketListener.getInstance());

        txtUpdateState.addKeyListener(EditTicketListener.getInstance());
        txtTitleUpdateCase.addKeyListener(EditTicketListener.getInstance());
        txtTitleConclusion.addKeyListener(EditTicketListener.getInstance());
        txtTitleCita.addKeyListener(EditTicketListener.getInstance());

        txtFechaCita.addKeyListener(EditTicketListener.getInstance());
        txtTitle.addKeyListener(EditTicketListener.getInstance());
        txtAgenteA.addKeyListener(EditTicketListener.getInstance());

        btnUpdateTime.addActionListener(TicketInfoListener.getInstance());
        btnUpdateTime.setActionCommand("UpdateTime");

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
        lblTotalTime.setText("Tiempo Total: " + ticket.getTimeByState().stream()
            .map(o -> o.replace("\\s+", "").replace("h", "").replace(" ", ""))
            .reduce((a, b) -> String.valueOf(Integer.parseInt(a) + Integer.parseInt(b))).get());

        btnUpdate.addActionListener(TicketInfoListener.getInstance());
        btnUpdate.setActionCommand("Update");
    }

    private void setTexts(Ticket ticket) {
        lblName.setText(ticket.getClientName());
        lblEmail.setText(ticket.getClientEmail());
        lblNumber.setText(ticket.getClientCellPhoneNumber());
        lblSource.setText(ticket.getSourceRequest().getContactMethod());
        lblPriority.setText(ticket.getTicketPriority().getPriority().getPriorityType());
        lblType.setText(ticket.getTicketServiceType().getTicketServiceType());
        lblAsigned.setText(ticket.getAssignedTechnician().getAssignedTechnician());
        lblPlazo.setText("Plazo de entrega : " + Controller.getInstance().getPlazo(ticket.getTicketPriority().getPriority()) + " horas");
        lblCreationDate.setText("Fecha de Creación: " + ticket.getTicketCreationDate()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        lblHastTags.setText(ticket.getTicketHashtags().getHashtags());
        lblTotalTime.setVisible(false);
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

    public void isTextInField() {
        if (!txtTitleUpdateCase.getText().isEmpty() || !txaUpdateCase.getText().isEmpty()) {
            txtFechaCita.setEnabled(false);
            txaFinished.setEnabled(false);
            txtTitleCita.setEnabled(false);
            txtTitleConclusion.setEnabled(false);
            txtUpdateState.setEnabled(false);
            txaCita.setEnabled(false);
            txaUpdateState.setEnabled(false);
            txaState.setEnabled(false);
            txtAgenteA.setEnabled(false);
            typeUpdate = 3;
            txtTitle.setEnabled(false);
        } else if (!txtFechaCita.getText().isEmpty() || !txtTitleCita.getText().isEmpty() || !txaCita.getText()
            .isEmpty()) {
            txtTitleUpdateCase.setEnabled(false);
            txtUpdateState.setEnabled(false);
            txaFinished.setEnabled(false);
            txaUpdateCase.setEnabled(false);
            txaUpdateState.setEnabled(false);
            txtTitleConclusion.setEnabled(false);
            txtTitle.setEnabled(false);
            txaState.setEnabled(false);
            txtAgenteA.setEnabled(false);
            typeUpdate = 2;
        } else if (!txtUpdateState.getText().isEmpty() || !txaUpdateState.getText().isEmpty()) {
            txtTitleUpdateCase.setEnabled(false);
            txtFechaCita.setEnabled(false);
            txtTitleCita.setEnabled(false);
            txaCita.setEnabled(false);
            txaFinished.setEnabled(false);
            txtTitleConclusion.setEnabled(false);
            txaUpdateCase.setEnabled(false);
            txtTitle.setEnabled(false);
            txaState.setEnabled(false);
            txtAgenteA.setEnabled(false);
            typeUpdate = 1;
        } else if (!txtTitleConclusion.getText().isEmpty() || !txaFinished.getText().isEmpty()) {
            txtTitleUpdateCase.setEnabled(false);
            txtFechaCita.setEnabled(false);
            txtTitleCita.setEnabled(false);
            txaCita.setEnabled(false);
            txaUpdateCase.setEnabled(false);
            txaUpdateState.setEnabled(false);
            txtUpdateState.setEnabled(false);
            txtTitle.setEnabled(false);
            txaState.setEnabled(false);
            txtAgenteA.setEnabled(false);
            typeUpdate = 4;
        } else if (!txaState.getText().isEmpty() || !txtTitle.getText().isEmpty() || !txtAgenteA.getText().isEmpty()) {
            txtTitleUpdateCase.setEnabled(false);
            txtFechaCita.setEnabled(false);
            txtTitleCita.setEnabled(false);
            txaCita.setEnabled(false);
            txaUpdateCase.setEnabled(false);
            txaUpdateState.setEnabled(false);
            txtUpdateState.setEnabled(false);
            txaFinished.setEnabled(false);
            txtTitleConclusion.setEnabled(false);
            typeUpdate = 0;
        } else {
            txtTitle.setEnabled(true);
            txtTitleUpdateCase.setEnabled(true);
            txtFechaCita.setEnabled(true);
            txtTitleCita.setEnabled(true);
            txaCita.setEnabled(true);
            txaUpdateCase.setEnabled(true);
            txaUpdateState.setEnabled(true);
            txtUpdateState.setEnabled(true);
            txtTitleConclusion.setEnabled(true);
            txaFinished.setEnabled(true);
            txtAgenteA.setEnabled(true);
        }
    }

    public int getTypeUpdate() {
        return typeUpdate;
    }

    public List<String> getUpdate() {
        return List.of(lblIdTicket.getText().substring(8), txtUpdateState.getText(), txaState.getText());
    }

    public List<String> getCita() {
        return List.of(
            lblIdTicket.getText().substring(8), txtTitleCita.getText(), txaCita.getText(), txtFechaCita.getText());
    }

    public List<String> getUpdateCase() {
        return List.of(lblIdTicket.getText().substring(8), txtTitleUpdateCase.getText(), txaUpdateCase.getText());
    }

    public List<String> getConclusion() {
        return List.of(lblIdTicket.getText().substring(8), txtTitleConclusion.getText(), txaFinished.getText());
    }

    public List<String> getDataType0() {
        List<String> data = List.of(lblIdTicket.getText().substring(8), txtTitle.getText(), txtTitle.getText(),
                                    txaState.getText(), txtAgenteA.getText());
        return data;
    }

    public List<String> getDataType3() {
        List<String> data = List.of(
            lblIdTicket.getText().substring(8), txtTitleUpdateCase.getText(), txaUpdateCase.getText());
        return data;
    }

    public List<String> getDataType1() {
        System.out.println(lblIdTicket.getText().substring(8));
        return List.of(lblIdTicket.getText().substring(8), txtUpdateState.getText(), txaUpdateState.getText());
    }

    public List<String> getDataType2() {
        return List.of(
            lblIdTicket.getText().substring(8), txtTitleCita.getText(), txaCita.getText(), txtFechaCita.getText());
    }

    public StateType getState() {
        return JPanelTicketInfo.getInstance().getTicket().getTicketStatus().getActualState();
    }

    public List<String> getDataType4() {
        return List.of(lblIdTicket.getText().substring(8), txtTitleConclusion.getText(), txaFinished.getText());
    }

    public TicketServiceType getServiceType() {
        return (TicketServiceType) cmbType.getSelectedItem();
    }

    public AssignedTechnician getAgent() {
        return (AssignedTechnician) cmbAsigned.getSelectedItem();
    }

    public PriorityType getPriority() {
        return (PriorityType) cmbPrioriry.getSelectedItem();
    }

    public void clearAndClose() {
        // clear all fields
        txtTitle.setText("");
        txtTitleUpdateCase.setText("");
        txtFechaCita.setText("");
        txtTitleCita.setText("");
        txaCita.setText("");
        txaUpdateCase.setText("");
        txaUpdateState.setText("");
        txtUpdateState.setText("");
        txaFinished.setText("");
        txtTitleConclusion.setText("");
        txtAgenteA.setText("");
        // close window
        this.dispose();
    }
}
