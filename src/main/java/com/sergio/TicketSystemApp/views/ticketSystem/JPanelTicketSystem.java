package com.sergio.TicketSystemApp.views.ticketSystem;


import com.sergio.TicketSystemApp.controllers.Controller;
import com.sergio.TicketSystemApp.views.home.HomeListener;
import com.sergio.TicketSystemApp.views.ticketSystem.components.TicketSystemPassword.JDialogTicketSystemPassword;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
    private JDialogTicketSystemPassword dialogTicketSystemPassword;
    private static JPanelTicketSystem instance;

    private String[] header;
    private List<?> tickets;
    private String[][] data = new String[][]{
        {"1",toHtml("asunto1\nAsunto2\nasunto3"),"urgente","final","tipo"},
        {"2","asunto 2","urgente","final","0123456789012345678901234567890"},
        {"3","asunto 3","urgente","final","0123456789012345678901234567890"},
        {"4","asunto 4","urgente","final","0123456789012345678901234567890"},
        {"5","asunto 5","urgente","final","0123456789012345678901234567890"},
        {"6","asunto 6","urgente","final","0123456789012345678901234567890"},
        {"7","asunto 7","urgente","final","tipo"},
        {"8","asunto 8","urgente","final","tipo"},
        {"9","asunto 9","urgente","final","tipo"},
        {"10","asunto 10","urgente","final","tipo"},
        {"11","asunto 11","urgente","final","tipo"},
        {"12","asunto 12","urgente","final","tipo"},
        {"13","asunto 13","urgente","final","tipo"},
        {"14","asunto 14","urgente","final","tipo"},
        {"15","asunto 15","urgente","final","tipo"},
        {"16","asunto 16","urgente","final","tipo"},
        {"17","asunto 17","urgente","final","tipo"},
        {"18","asunto 18","urgente","final","tipo"},
        {"19","asunto 19","urgente","final","tipo"},
        {"20","asunto 20","urgente","final","tipo"},
        {"21","asunto 21","urgente","final","tipo"},
        {"22","asunto 22","urgente","final","tipo"},
        {"23","asunto 23","urgente","final","tipo"},
        {"24","asunto 24","urgente","final","tipo"},
        {"25","asunto 25","urgente","final","tipo"},
        {"26","asunto 26","urgente","final","tipo"},
        {"27","asunto 27","urgente","final","tipo"},
        {"28","asunto 28","urgente","final","tipo"},
        {"29","asunto 29","urgente","final","tipo"},
        {"30","asunto 30","urgente","final","tipo"},
        {"31","asunto 31","urgente","final","tipo"},
    };

    public JPanelTicketSystem() {
        instance = this;
        header = new String[]{"Ticket", "Asunto del Ticket", "Prioridad", "Estado", "Tipo y Etiquetas"};
        dialogTicketSystemPassword = JDialogTicketSystemPassword.getInstance();
        setSize(800, 600);
        initComponents();
        setContentPane(panelTicketSystem);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ticket System");
    }

    public void setTickets() {
        // TODO: Implement complete functionality
        data = new String[tickets.size()][5];
        for (int i = 0; i < tickets.size(); i++) {
            data[i][0] = "#" + tickets.get(i);
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = "";
            data[i][4] = "";
        }
        jTableTicketSystem.setModel(new DefaultTableModel(data, header));
    }

    private void initComponents() {
        TableModel tableModel = new DefaultTableModel(data, header);

        jTableTicketSystem.setModel(tableModel);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(1).setMinWidth(300);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(60);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(200);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(4).setMinWidth(150);
        jTableTicketSystem.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(200);

        jTableTicketSystem.setAutoCreateRowSorter(true);

        jTableTicketSystem.setRowHeight(50);

        getData();
        setCounters();
    }

    private void getData() {
        tickets = Controller.getInstance().getTickets();
    }

    private void setCounters() {
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
        System.out.println(password);
        // TODO: Check password
        if (password.equals("admin")) {
            hideDialogTicketSystemPassword();
            setVisible(true);
            System.out.println("SigIn");
        } else {
            JOptionPane.showMessageDialog(this, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JPanelTicketSystem jPanelTicketSystem = new JPanelTicketSystem();
        jPanelTicketSystem.setVisible(true);
    }
}
