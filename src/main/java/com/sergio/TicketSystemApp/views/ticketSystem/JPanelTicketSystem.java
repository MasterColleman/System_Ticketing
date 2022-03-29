package com.sergio.TicketSystemApp.views.ticketSystem;


import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.model.Ticket;
import com.sergio.TicketSystemApp.views.ticketSystem.components.TicketSystemPassword.JDialogTicketSystemPassword;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

import static com.sergio.TicketSystemApp.utils.StringUtils.toHtml;

public class JPanelTicketSystem extends JFrame {
    private JPanel panelTicketSystem;
    private JTable jTableTicketSystem;
    private JScrollPane jScrollPaneTicketSystem;
    private JLabel TitleTicketTable;

    private JLabel lblNumberInSolution;
    private JLabel lblNumberWaiting;
    private JLabel lblNumberReception;
    private JLabel lblNumberTesting;
    private JLabel lblNumberConcluded;
    private JLabel lblNumberInProcess;

    private JLabel lblTextSolution;
    private JLabel lblTextWaiting;
    private JLabel lblTextReception;
    private JLabel lblTextConcluded;
    private JLabel lblTextTesting;
    private JLabel lblTextProcess;
    private JLabel lblTitle;
    private JLabel lblSubtitle;
    private JLabel lblDescription;
    private final JDialogTicketSystemPassword dialogTicketSystemPassword;
    private static JPanelTicketSystem instance;

    private final String[] header;
    private List<Ticket> tickets;
    private String[][] data = new String[][]{};

    public JPanelTicketSystem() {
        instance = this;
        header = new String[]{"Ticket", "Asunto del Ticket", "Prioridad", "Estado", "Tipo y Etiquetas"};
        dialogTicketSystemPassword = JDialogTicketSystemPassword.getInstance();
        setSize(800, 600);

        initComponents();
        setContentPane(panelTicketSystem);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        setTitle("Ticket System");
    }

    public void setTickets() {
        data = new String[tickets.size()][5];
        for (int i = 0; i < tickets.size(); i++) {
            data[i][0] = "" + tickets.get(i).getTicketNumber();
            data[i][1] = toHtml(tickets.get(i).getTicketName() + "\n" + tickets.get(i).getClientName());
            data[i][2] = "" + tickets.get(i).getTicketPriority().getPriority().getPriorityType();
            data[i][3] = "" + tickets.get(i).getTicketStatus().getActualState().getStateType();
            data[i][4] = "" + tickets.get(i).getTicketServiceType().getTicketServiceType();

        }
        jTableTicketSystem.setModel(new DefaultTableModel(data, header));

    }

    private void initComponents() {


        getData();
        setCounters();
        setTickets();
        TableModel tableModel = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableTicketSystem.setModel(tableModel);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(1).setMinWidth(300);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(60);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(200);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(4).setMinWidth(150);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(200);
        jTableTicketSystem.setAutoCreateRowSorter(true);
        jTableTicketSystem.setRowHeight(50);

        jTableTicketSystem.addMouseListener(TicketSystemListener.getInstance());
        jTableTicketSystem.setName("btnClickTickets");

    }

    private void getData() {
        tickets = Controller.getInstance().getTickets();
    }

    private void setCounters() {
        lblNumberInSolution.setText("" + Controller.getInstance().getTicketsByState(0).size());
        lblNumberWaiting.setText("" + Controller.getInstance().getTicketsByState(1).size());
        lblNumberReception.setText("" + Controller.getInstance().getTicketsByState(2).size());
        lblNumberTesting.setText("" + Controller.getInstance().getTicketsByState(3).size());
        lblNumberConcluded.setText("" + Controller.getInstance().getTicketsByState(4).size());
        lblNumberInProcess.setText("" + Controller.getInstance().getTicketsByState(5).size());
    }

    public static JPanelTicketSystem getInstance() {
        if (instance == null) {
            instance = new JPanelTicketSystem();
        }
        return instance;
    }

    public void showDialogTicketSystemPassword() {
        dialogTicketSystemPassword.setVisible(true);
    }

    public void hideDialogTicketSystemPassword() {
        dialogTicketSystemPassword.setVisible(false);
    }

    public void sigIn() {
        String password = dialogTicketSystemPassword.getPassword();
        if (password.equals("admin")) {
            hideDialogTicketSystemPassword();
            initComponents();
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Ticket getTicket() {
        int row = jTableTicketSystem.getSelectedRow();
        String id = jTableTicketSystem.getValueAt(row, 0).toString();
        if (row != -1) {
            for (Ticket ticket : tickets) {
                if (ticket.getTicketNumber().equals(id)) {
                    return ticket;
                }
            }
        }
        return null;
    }
}
