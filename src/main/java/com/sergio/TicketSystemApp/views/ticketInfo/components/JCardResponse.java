package com.sergio.TicketSystemApp.views.ticketInfo.components;

import javax.swing.*;
import java.awt.*;

public class JCardResponse extends JPanel {
    private JPanel contentPane;

    private JPanel contentPanel;
    private JPanel infoPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JLabel infoLabel;
    private JLabel timeLabel;
    private JTextArea textArea1;
    private JLabel titleLabelC;


    public JCardResponse(){
        add(contentPane);
        setBackground(Color.WHITE);
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        infoPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        infoPanel.setBackground(new Color(255, 255, 255));
        titlePanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        titlePanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        contentPanel.setBackground(new Color(255, 255, 255));
        setVisible(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setTitleResponse(String titleBig, String title, String subtitle, String time){
        titleLabelC.setText(title);
        titleLabel.setText(titleBig);
        infoLabel.setText(subtitle);
        timeLabel.setText(time);
        textArea1.setEditable(false);
    }

    public void setContentResponse(String content){
        textArea1.setText(content);
    }

    public void setSizetxtArea(Dimension size) {
        textArea1.setPreferredSize(size);
    }


}
