package com.sergio.TicketSystemApp.views.ticketInfo.components;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class JCardTicket extends JPanel {

    private JTextArea contentTextArea;
    private JLabel titleCard;
    private JPanel content;
    private JPanel titlePanel;
    private JPanel headerPanel;
    private JPanel textAreaPanel;
    private JLabel titleTicket;
    private JLabel titleMedia;
    private JLabel titleOpen;
    private JPanel contentPanel;

    public JCardTicket() {
        add(content);
        content.setBackground(new Color(255, 255, 255));
        content.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(.8f)));
        titlePanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        titlePanel.setBackground(new Color(255, 255, 255));
        headerPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        headerPanel.setBackground(new Color(255, 255, 255));
        textAreaPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        textAreaPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBackground(new Color(255, 255, 255));
        contentTextArea.setEditable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public void setTitle(String title, String titleBox, String subTitle, String time) {
        titleCard.setText(title);
        titleTicket.setText(titleBox);
        titleMedia.setText(subTitle);
        titleOpen.setText(time);
    }

    public void setContent(String content) {
        this.contentTextArea.setText(content);

    }

    public void setSizetxtArea(Dimension size) {
        contentTextArea.setPreferredSize(size);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("JCardTicket");
        frame.setBackground(new Color(255, 255, 255));
        frame.setContentPane(new JCardTicket().content);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
